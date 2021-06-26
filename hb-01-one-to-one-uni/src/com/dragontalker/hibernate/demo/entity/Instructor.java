package com.dragontalker.hibernate.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {
	
	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String email;

}
