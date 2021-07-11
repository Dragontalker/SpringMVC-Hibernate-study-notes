package com.dragontalker.springboot.thymeleafdemo.model;

public class Employee {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	
	public Employee() {
		
	}

	public Employee(int id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
}
