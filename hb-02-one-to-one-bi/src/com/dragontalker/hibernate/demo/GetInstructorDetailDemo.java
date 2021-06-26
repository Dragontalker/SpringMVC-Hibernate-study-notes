package com.dragontalker.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dragontalker.hibernate.demo.entity.Instructor;
import com.dragontalker.hibernate.demo.entity.InstructorDetail;


public class GetInstructorDetailDemo {

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
        	// start a transaction
            session.beginTransaction();

            // get the instructor detail object
            int theId = 2;
            InstructorDetail tempInstructorDetail =
            		session.get(InstructorDetail.class, theId);
            
            // print the instructor detail
            
            // print the associated instructor

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!!!");

        } finally {
            factory.close();
        }
    }
}