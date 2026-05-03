package com.dentali.core.exceptions;

public class CitaNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -1080623232882746163L;
	
	public CitaNotFoundException(String message){
		super(message);
	}

}
