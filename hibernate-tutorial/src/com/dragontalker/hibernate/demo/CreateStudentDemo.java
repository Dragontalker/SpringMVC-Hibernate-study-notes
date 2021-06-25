package com.dragontalker.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dragontalker.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session

	}

}
