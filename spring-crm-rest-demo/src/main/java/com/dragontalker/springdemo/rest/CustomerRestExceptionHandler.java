package com.dragontalker.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {
	
	// Add an exception handler for CustomerNotFoundException
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(
			CustomerNotFoundException exception) {
		
		// create CustomerErrorResponse
		CustomerErrorResponse error = 
				new CustomerErrorResponse(
						HttpStatus.NOT_FOUND.value(),
						exception.getMessage(),
						System.currentTimeMillis());
		
		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}
	
	// Add another exception handler ... to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(
			Exception exception) {
		
		// create CustomerErrorResponse
		CustomerErrorResponse error = 
				new CustomerErrorResponse(
						HttpStatus.BAD_REQUEST.value(),
						exception.getMessage(),
						System.currentTimeMillis());
		
		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}
	
}
