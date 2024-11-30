package com.flexshose.flexshoesbackend.configuration;

import java.text.ParseException;
import java.util.Objects;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Component;

import com.flexshose.flexshoesbackend.dto.request.IntrospectRequest;
import com.flexshose.flexshoesbackend.dto.response.IntrospectResponse;
import com.flexshose.flexshoesbackend.exception.MyAppException;
import com.flexshose.flexshoesbackend.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;


@Component
public class CustomJWTDecoder implements JwtDecoder {
	
	@Value("${app.keySigner}")
	String keySigner;

	@Autowired
	private AuthenticationService authenticationService;

	private NimbusJwtDecoder nimbusJwtDecoder = null;

	@Override
	public Jwt decode(String token) throws JwtException {

		try {
			IntrospectResponse response = authenticationService.introspect(IntrospectRequest.builder().token(token).build());
			if (!response.isValid())
				throw new JwtException("Token invalid");
		} catch (JOSEException | ParseException e) {
			throw new JwtException(e.getMessage());
		} catch (MyAppException e) {
			// TODO Auto-generated catch block
			throw new JwtException(e.getMessage());
		}

		if (Objects.isNull(nimbusJwtDecoder)) {
			SecretKeySpec secretKeySpec = new SecretKeySpec(keySigner.getBytes(), "HS512");
			nimbusJwtDecoder = NimbusJwtDecoder.withSecretKey(secretKeySpec).macAlgorithm(MacAlgorithm.HS512).build();
		}

		return nimbusJwtDecoder.decode(token);
	}

}
