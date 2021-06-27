package com.dragontalker.springdemo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
}
