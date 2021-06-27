package com.dragontalker.hibernate.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {
	
	private int id;
	
	private String comment;
	
	

}
