package com.dentali.core.exceptions.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.dentali.core.exceptions.CitaNotFoundException;
import com.dentali.core.exceptions.DoctorNotFoundException;
import com.dentali.core.exceptions.HistorialNotFoundException;
import com.dentali.core.exceptions.PacienteNotFoundException;
import com.dentali.core.exceptions.TratamientoNotFoundException;
import com.dentali.core.exceptions.UserNotFoundException;
import com.dentali.core.exceptions.entities.Error;

@RestControllerAdvice
public class HandlerExceptionController {

	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Error> divisionByZero(Exception ex){
		Error error = new Error();
		error.setDate(new Date());
		error.setError("Error división por Cero.");
		error.setMessage(ex.getMessage());
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return ResponseEntity.internalServerError().body(error);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundException(NoHandlerFoundException e){
        Error error = new Error();
        error.setDate(new Date());
        error.setError("API Rest no encontrado");
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(403).body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> NumberFormatException(Exception ex){
        Map<String, String> error = new HashMap<>();

        error.put("date", new Date().toString());
        error.put("error", "Número incorrecto sin formato de digito.");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value()+" ");
        return error;
    }

    @ExceptionHandler({NullPointerException.class, 
                        HttpMessageNotWritableException.class,
                        UserNotFoundException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> userNotFoundException(Exception ex){
        Map<String, String> error = new HashMap<>();

        error.put("date", new Date().toString());
        error.put("error", "El usuario o Rol no existe.");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value()+" ");
        return error;
    }
   
    @ExceptionHandler({CitaNotFoundException.class})
    public Map<String, String> citaNotFoundException(Exception ex){
		Map<String, String> error = new HashMap<>();

		error.put("date", new Date().toString());
		error.put("error", "La Cita no existe.");
		error.put("message", ex.getMessage());
		error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value()+" ");
		return error;
	
    }
    
    @ExceptionHandler({DoctorNotFoundException.class})
    public Map<String, String> doctorNotFoundException(Exception ex){
		Map<String, String> error = new HashMap<>();

		error.put("date", new Date().toString());
		error.put("error", "La Cita no existe.");
		error.put("message", ex.getMessage());
		error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value()+" ");
		return error;
	
    }

    @ExceptionHandler({PacienteNotFoundException.class})
    public Map<String, String> pacienteNotFoundException(Exception ex){
		Map<String, String> error = new HashMap<>();

		error.put("date", new Date().toString());
		error.put("error", "La Cita no existe.");
		error.put("message", ex.getMessage());
		error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value()+" ");
		return error;
	
    }

    @ExceptionHandler({TratamientoNotFoundException.class})
    public Map<String, String> tratamientoNotFoundException(Exception ex){
		Map<String, String> error = new HashMap<>();

		error.put("date", new Date().toString());
		error.put("error", "La Cita no existe.");
		error.put("message", ex.getMessage());
		error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value()+" ");
		return error;
	
    }

    @ExceptionHandler({HistorialNotFoundException.class})
    public Map<String, String> historialNotFoundException(Exception ex){
		Map<String, String> error = new HashMap<>();

		error.put("date", new Date().toString());
		error.put("error", "La Cita no existe.");
		error.put("message", ex.getMessage());
		error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value()+" ");
		return error;
	
    }
    
	
}
