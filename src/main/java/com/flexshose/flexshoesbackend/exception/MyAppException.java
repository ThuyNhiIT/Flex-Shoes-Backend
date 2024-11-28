package com.flexshose.flexshoesbackend.exception;


public class MyAppException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private ErrorCode errorCode;


	public MyAppException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	
	
	
	
	
}
