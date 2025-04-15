package com.dentali.errors.exceptions;

public class PacienteNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public PacienteNotFoundException(String message){
        super(message);
    }

}
