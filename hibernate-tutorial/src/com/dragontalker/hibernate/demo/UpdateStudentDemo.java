package com.dragontalker.hibernate.demo;

import com.dragontalker.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
        	int studentId = 1;
        	
            // start a transaction
            session.beginTransaction();

            // retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + studentId);
            
            Student myStudent = session.get(Student.class, studentId);
            
            System.out.println("Get complete: " + myStudent);
            
            // commit the transaction
            session.getTransaction().commit();
            
            System.out.println("Done!!!");

        } finally {
            factory.close();
        }
    }
}