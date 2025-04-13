package com.dentali.errors.exceptions;

public class UserNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 8060196248713999027L;

	public UserNotFoundException(String message){
        super(message);
    }

}
