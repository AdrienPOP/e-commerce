package com.ap_commerce.engine.authentication.exceptions;

public class UserAlreadyExistException extends Exception {

	private static final long serialVersionUID = -8175185672367462213L;

	public UserAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserAlreadyExistException(String message) {
		super(message);
	}
	
	

}
