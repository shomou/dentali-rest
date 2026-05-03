package com.dentali.core.exceptions;

public class TratamientoNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public TratamientoNotFoundException(String message){
        super(message);
    }

}
