package com.ey.starter.handler;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ey.starter.error.ApiError;


@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({ ConstraintViolationException.class, javax.validation.ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
	  
		String error = ex.getClass().getName() + " " + ex.getCause().getMessage();
	  
	    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
	    
	    return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getHttpStatus());
	}
	
	@ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		String error = ex.getClass().getName() + " " + ex.getCause().getMessage();
		
		if (ex.getCause().getCause() != null) {
			error = error + " ERRO: " + ex.getCause().getCause().getMessage(); 
		}
		
		  
	    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
	    
	    return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getHttpStatus());
    }
	

}
