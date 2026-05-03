package com.dentali.core.exceptions;

public class HistorialNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    
    public HistorialNotFoundException(String message){
        super(message);
    }

}
