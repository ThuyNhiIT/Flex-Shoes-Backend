package com.flexshose.flexshoesbackend.service;

import java.text.ParseException;

import com.flexshose.flexshoesbackend.dto.request.AuthenticationRequest;
import com.flexshose.flexshoesbackend.dto.request.IntrospectRequest;
import com.flexshose.flexshoesbackend.dto.request.LogoutRequest;
import com.flexshose.flexshoesbackend.dto.request.RefreshTokenRequest;
import com.flexshose.flexshoesbackend.dto.response.AuthenticationResponse;
import com.flexshose.flexshoesbackend.dto.response.IntrospectResponse;
import com.flexshose.flexshoesbackend.exception.MyAppException;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.SignedJWT;

public interface AuthenticationService {
	public AuthenticationResponse authenticate(AuthenticationRequest authentication) throws MyAppException;
	public IntrospectResponse introspect(IntrospectRequest request) throws MyAppException, JOSEException, ParseException;
	public void logout(LogoutRequest request) throws MyAppException, ParseException, JOSEException;
	public SignedJWT verifyToken(String token, boolean isRefresh) throws MyAppException, JOSEException, ParseException;
	public AuthenticationResponse refreshToken(RefreshTokenRequest request) throws ParseException, JOSEException, MyAppException;
}
