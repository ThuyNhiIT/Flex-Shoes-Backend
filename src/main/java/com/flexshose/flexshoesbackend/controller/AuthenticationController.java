package com.flexshose.flexshoesbackend.controller;

import java.text.ParseException;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flexshose.flexshoesbackend.dto.request.AuthenticationRequest;
import com.flexshose.flexshoesbackend.dto.request.IntrospectRequest;
import com.flexshose.flexshoesbackend.dto.request.LogoutRequest;
import com.flexshose.flexshoesbackend.dto.request.RefreshTokenRequest;
import com.flexshose.flexshoesbackend.dto.response.AuthenticationResponse;
import com.flexshose.flexshoesbackend.dto.response.IntrospectResponse;
import com.flexshose.flexshoesbackend.dto.response.MyAPIResponse;
import com.flexshose.flexshoesbackend.exception.MyAppException;
import com.flexshose.flexshoesbackend.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthenticationController {
	AuthenticationService authService;
	
	@PostMapping("/login")
	public MyAPIResponse<AuthenticationResponse>  login(@RequestBody AuthenticationRequest request) throws MyAppException{
		
		AuthenticationResponse response = authService.authenticate(request);
		
		
       return MyAPIResponse.<AuthenticationResponse>builder()
    		   .result(
    				  response
    				   )
    		   .build();
       
      
       
	}
	@PostMapping("/introspect")
	public MyAPIResponse<IntrospectResponse>  introspect(@RequestBody IntrospectRequest request) throws MyAppException, JOSEException, ParseException{
		IntrospectResponse response = authService.introspect(request);
       return MyAPIResponse.<IntrospectResponse>builder()
    		   .result(response)
    		   .build();
	}
	@PostMapping("/logout")
	public MyAPIResponse<Void> logout(@RequestBody LogoutRequest request) throws MyAppException, JOSEException, ParseException{
		authService.logout(request);
		return MyAPIResponse.<Void>builder().build();
	}
	 @PostMapping("/refresh")
	 MyAPIResponse<AuthenticationResponse> authenticate(@RequestBody RefreshTokenRequest request)
	            throws ParseException, JOSEException, MyAppException {
		 AuthenticationResponse result = authService.refreshToken(request);
	        return MyAPIResponse.<AuthenticationResponse>builder().result(result).build();
	    }
        	
}
