package com.dragontalker.hibernate.demo;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dragontalker.hibernate.demo.entity.Course;
import com.dragontalker.hibernate.demo.entity.Instructor;
import com.dragontalker.hibernate.demo.entity.InstructorDetail;



public class FetchJoinDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
        	// start a transaction
            session.beginTransaction();
            
            // option 2: Hibernate query with HQL
            
            // get the instructor from db
            int theId = 1;
            
            Query<Instructor> query = 
            		session.createQuery("select i from Instructor i " 
            					+ "JOIN FETCH i.courses " 
            					+ "where i.id=:theInstructorId",
            				Instructor.class);
            
            // set parameter on query
            query.setParameter("theInstructorId", theId);
            
            // execute query and get instructor
            Instructor tempInstructor = query.getSingleResult();
            
            System.out.println(">> dragontalker: Instructor: " + tempInstructor);

            // commit the transaction
            session.getTransaction().commit();
            
            // close the session
            session.close();
            
            System.err.println("\n>> Session is now closed!\n");
            
            // get courses for the instructor
            System.out.println(">> After session.close(): Courses: " + tempInstructor.getCourses());

            System.out.println(">> dragontalker: Done!!!");

        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
        	// add clean up code
        	session.close();
        	
            factory.close();
        }
    }
}