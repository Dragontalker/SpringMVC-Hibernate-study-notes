package com.dragontalker.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dragontalker.hibernate.demo.entity.Instructor;
import com.dragontalker.hibernate.demo.entity.InstructorDetail;


public class CreateDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
        	// create the objects
        	Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
        	
        	InstructorDetail tempInstructorDetail =
        			new InstructorDetail(
        					"http://www.luv2code.com/youtube",
        					"Luv 2 code!!!");
        	
            // start a transaction
            session.beginTransaction();

          

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!!!");

        } finally {
            factory.close();
        }
    }
}