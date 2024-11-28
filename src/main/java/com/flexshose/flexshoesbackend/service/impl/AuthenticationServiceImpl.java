package com.flexshose.flexshoesbackend.service.impl;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.StringJoiner;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.flexshose.flexshoesbackend.dto.request.AuthenticationRequest;
import com.flexshose.flexshoesbackend.dto.request.IntrospectRequest;
import com.flexshose.flexshoesbackend.dto.request.LogoutRequest;
import com.flexshose.flexshoesbackend.dto.request.RefreshTokenRequest;
import com.flexshose.flexshoesbackend.dto.response.AuthenticationResponse;
import com.flexshose.flexshoesbackend.dto.response.IntrospectResponse;
import com.flexshose.flexshoesbackend.entity.Account;
import com.flexshose.flexshoesbackend.entity.InvalidToken;
import com.flexshose.flexshoesbackend.entity.Role;
import com.flexshose.flexshoesbackend.exception.ErrorCode;
import com.flexshose.flexshoesbackend.exception.MyAppException;
import com.flexshose.flexshoesbackend.repository.AccountRepository;
import com.flexshose.flexshoesbackend.repository.InvalidTokenRepository;
import com.flexshose.flexshoesbackend.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.Payload;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class AuthenticationServiceImpl implements AuthenticationService {

	PasswordEncoder passwordEncoder;
	AccountRepository accountRepository;
	InvalidTokenRepository invalidTokenRepository;
	@NonFinal
	@Value("${app.keySigner}")
	String keySigner;

	@NonFinal
	@Value("${app.valid-duration}")
	protected long VALID_DURATION;

	@NonFinal
	@Value("${app.refreshable-duration}")
	protected long REFRESHABLE_DURATION;

	@Override
	public AuthenticationResponse authenticate(AuthenticationRequest request) throws MyAppException {
		try {
			Account account = accountRepository.findByUsername(request.getUsername())
					.orElseThrow(() -> new MyAppException(ErrorCode.USER_NOT_EXISTED));
			Role role = account.getRole();
			boolean authenticated = passwordEncoder.matches(request.getPassword(), account.getPassword());
			if (!authenticated)
				throw new MyAppException(ErrorCode.INVALID_PASSWORD);

			String token = generateToken(account);
			return AuthenticationResponse.builder().authenticated(true).token(token).role(role.toString()).build();
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyAppException(ErrorCode.ACTION_FAILD);

		}
	}

	private String generateToken(Account account) throws MyAppException {
		JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);
		String customerName = (account.getCustomer() == null) ? "Admin" : account.getCustomer().getCustomerName();
		JWTClaimsSet claimsSet = new JWTClaimsSet.Builder().subject(account.getUsername()).issuer("flexshoes.com")
				.issueTime(new Date()).expirationTime(new Date(Instant.now().plus(VALID_DURATION, ChronoUnit.SECONDS).toEpochMilli()))
				.claim("role", buildScope(account)).claim("owner", customerName).jwtID(UUID.randomUUID().toString())
				.build();
		Payload payload = new Payload(claimsSet.toJSONObject());

		JWSObject jwsObject = new JWSObject(header, payload);

		try {
			jwsObject.sign(new MACSigner(keySigner.getBytes()));
			return jwsObject.serialize();
		} catch (JOSEException e) {
			throw new MyAppException(ErrorCode.ACTION_FAILD);
		}
	}

	@Override
	public IntrospectResponse introspect(IntrospectRequest request)
			throws MyAppException, JOSEException, ParseException {
		String token = request.getToken();
		boolean valid = true;

		try {
			verifyToken(token, false);
		} catch (MyAppException e) {
			valid = false;
		}
		return IntrospectResponse.builder().valid(valid).build();

	}

	private String buildScope(Account account) {
		StringJoiner joiner = new StringJoiner(" ");
		if (account.getRole().equals(Role.ADMIN)) {
			joiner.add("ADMIN");
		} else {
			joiner.add("USER");
		}
		return joiner.toString();
	}

	@Override
	public void logout(LogoutRequest request) throws MyAppException, ParseException, JOSEException {
		// TODO Auto-generated method stub
		SignedJWT signToken = verifyToken(request.getToken(), true);

		String jti = signToken.getJWTClaimsSet().getJWTID();

		Date expiryTime = signToken.getJWTClaimsSet().getExpirationTime();

		InvalidToken invalidateToken = InvalidToken.builder().id(jti).expiredDate(expiryTime).build();

		invalidTokenRepository.save(invalidateToken);
	}

	@Override
	public SignedJWT verifyToken(String token, boolean isRefresh) throws MyAppException, JOSEException, ParseException {
		JWSVerifier verifier = new MACVerifier(keySigner.getBytes());

		SignedJWT signedJWT = SignedJWT.parse(token);

		Date expiryTime = (isRefresh)
				? new Date(signedJWT.getJWTClaimsSet().getIssueTime().toInstant()
						.plus(REFRESHABLE_DURATION, ChronoUnit.SECONDS).toEpochMilli())
				: signedJWT.getJWTClaimsSet().getExpirationTime();

		boolean valid = signedJWT.verify(verifier);

		if (!(valid && expiryTime.after(new Date()))) {
			throw new MyAppException(ErrorCode.UNAUTHENTICATED);
		}
		if (invalidTokenRepository.existsById(signedJWT.getJWTClaimsSet().getJWTID())) {
			throw new MyAppException(ErrorCode.UNAUTHENTICATED);
		}
		return signedJWT;
	}

	@Override
	public AuthenticationResponse refreshToken(RefreshTokenRequest request) throws ParseException, JOSEException, MyAppException {
		SignedJWT signedJWT = verifyToken(request.getToken(), true);

		String jit = signedJWT.getJWTClaimsSet().getJWTID();
		Date expiryTime = signedJWT.getJWTClaimsSet().getExpirationTime();

		InvalidToken invalidatedToken = InvalidToken.builder().id(jit).expiredDate(expiryTime).build();

		invalidTokenRepository.save(invalidatedToken);

		String username = signedJWT.getJWTClaimsSet().getSubject();

		Account user = accountRepository.findByUsername(username).orElseThrow(() -> new MyAppException(ErrorCode.UNAUTHENTICATED));
			
		var token = generateToken(user);

		return AuthenticationResponse.builder().token(token).authenticated(true).build();
	}

}
