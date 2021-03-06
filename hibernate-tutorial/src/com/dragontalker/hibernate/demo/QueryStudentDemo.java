package com.dragontalker.hibernate.demo;

import com.dragontalker.hibernate.demo.entity.Student;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {

    @SuppressWarnings("unchecked")
	public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // query students
            List<Student> theStudents = 
            		session
            			.createQuery("from Student")
            			.getResultList();
            
            // display the students
            displayStudents(theStudents);
            
            // query students: lastName='Doe'
            theStudents = session
            		.createQuery("from Student s where s.lastName='Doe'")
            		.getResultList();
            
            // display the students
            System.out.println("\n\nStudents who has last name of Doe");
            displayStudents(theStudents);
            
            // query students: lastName='Doe' OR firstName='Daffy'
            theStudents = session
            		.createQuery("from Student s where"
            				+ " s.lastName='Doe' OR s.firstName='Daffy'")
            		.getResultList();
            
            // display the students
            System.out.println("\n\nStudents who has first name of Daffy");
            displayStudents(theStudents);
            
            // query students where email LIKE '%luv2code.com'
            theStudents = session
            		.createQuery("from Student s where" 
            				+ " s.email LIKE '%luv2code.com'")
            		.getResultList();
            
            // display the students
            System.out.println("\n\nStudents who has email ends with luv2code.com");
            displayStudents(theStudents);
            
            // query students where email LIKE '%gmail.com'
            theStudents = session
            		.createQuery("from Student s where" 
            				+ " s.email LIKE '%gmail.com'")
            		.getResultList();
            
            // display the students
            System.out.println("\n\nStudents who has email ends with gmail.com");
            displayStudents(theStudents);

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Done!!!");

        } finally {
            factory.close();
        }
    }

	private static void displayStudents(List<Student> theStudents) {
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}
}