package com.dragontalker.springdemo.rest;

public class CustomerErrorResponse {

	private int status;
	private String message;
	private long timeStamp;
	
	public CustomerErrorResponse() {}

	public CustomerErrorResponse(int status, String message, long timeStamp) {
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}
	
}
