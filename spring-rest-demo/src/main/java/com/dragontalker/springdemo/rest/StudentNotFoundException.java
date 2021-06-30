package com.dragontalker.springdemo.rest;

public class StudentNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 3621758046988970985L;

	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentNotFoundException(String message) {
		super(message);
	}

	public StudentNotFoundException(Throwable cause) {
		super(cause);
	}

}
