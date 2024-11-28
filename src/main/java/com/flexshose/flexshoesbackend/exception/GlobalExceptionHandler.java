package com.flexshose.flexshoesbackend.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.flexshose.flexshoesbackend.dto.response.MyAPIResponse;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    ResponseEntity<MyAPIResponse> handlingRuntimeException(RuntimeException exception) {
        log.error("Exception: ", exception);
        MyAPIResponse apiResponse = new MyAPIResponse<>();

        apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
        apiResponse.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());

        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = MyAppException.class)
    ResponseEntity<MyAPIResponse> handlingAppException(MyAppException exception) {
        ErrorCode errorCode = exception.getErrorCode();
        MyAPIResponse apiResponse = new MyAPIResponse<>();

        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());

        return ResponseEntity.status(errorCode.getStatusCode()).body(apiResponse);
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    ResponseEntity<MyAPIResponse> handlingAccessDeniedException(AccessDeniedException exception) {
        ErrorCode errorCode = ErrorCode.UNAUTHORIZED;

        return ResponseEntity.status(errorCode.getStatusCode())
                .body(MyAPIResponse.builder()
                        .code(errorCode.getCode())
                        .message(errorCode.getMessage())
                        .build());
    }
    @ExceptionHandler(value = AuthenticationServiceException.class)
    ResponseEntity<MyAPIResponse> handlingAuthenticationServiceException(AuthenticationServiceException exception) {
        ErrorCode errorCode = ErrorCode.INVALID_TOKEN;

        return ResponseEntity.status(errorCode.getStatusCode())
                .body(MyAPIResponse.builder()
                        .code(errorCode.getCode())
                        .message(errorCode.getMessage())
                        .build());
    }
    @ExceptionHandler(value = JwtException.class)
    ResponseEntity<MyAPIResponse> handlingJwtException(JwtException exception) {
        ErrorCode errorCode = ErrorCode.INVALID_TOKEN;

        return ResponseEntity.status(errorCode.getStatusCode())
                .body(MyAPIResponse.builder()
                        .code(errorCode.getCode())
                        .message(errorCode.getMessage())
                        .build());
    }


}
