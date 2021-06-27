package com.dragontalker.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dragontalker.hibernate.demo.entity.Course;
import com.dragontalker.hibernate.demo.entity.Instructor;
import com.dragontalker.hibernate.demo.entity.InstructorDetail;
import com.dragontalker.hibernate.demo.entity.Review;


public class GetCourseAndReviewsDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
        	// start a transaction
            session.beginTransaction();

            // get the course
            int theId = 10;
            Course tempCourse = session.get(Course.class, theId);
            
            // print the course
            System.out.println(">> " + tempCourse);
            
            // print the course reviews
            System.out.println(">> " + tempCourse.getReviews());
            
            // commit the transaction
            session.getTransaction().commit();

            System.out.println(">> Done!!!");

        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
        	// add clean up code
        	session.close();
        	
            factory.close();
        }
    }
}