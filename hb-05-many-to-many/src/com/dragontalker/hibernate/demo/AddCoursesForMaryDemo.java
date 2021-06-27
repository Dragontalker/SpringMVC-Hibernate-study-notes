package com.dragontalker.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dragontalker.hibernate.demo.entity.Course;
import com.dragontalker.hibernate.demo.entity.Instructor;
import com.dragontalker.hibernate.demo.entity.InstructorDetail;
import com.dragontalker.hibernate.demo.entity.Review;
import com.dragontalker.hibernate.demo.entity.Student;


public class AddCoursesForMaryDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
        	// start a transaction
            session.beginTransaction();

            // get the student mary from database
            int studentId = 2;
            Student tempStudent = session.get(Student.class, studentId);
            
            System.out.println("\n>> Loaded student: " + tempStudent);
            System.out.println(">> Courses: " + tempStudent.getCourses());
            
            // create more courses
            Course tempCourse1 = new Course("Rubik's Cude - How to Speed Cube");
            Course tempCourse2 = new Course("Atari 2600 - Game Development");
            
            // add student to courses
            tempCourse1.addStudent(tempStudent);
            tempCourse2.addStudent(tempStudent);
            
            // save the courses
            System.out.println("\n>>Saving the courses ...");
            
            session.save(tempCourse1);
            session.save(tempCourse2);
            
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
