package com.ap_commerce.engine.authentication.exceptions;

public class UserDoesNotExistException extends Exception {

	private static final long serialVersionUID = 2751637298117673123L;
	
	public  UserDoesNotExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public  UserDoesNotExistException(String message) {
		super(message);
	}

}
