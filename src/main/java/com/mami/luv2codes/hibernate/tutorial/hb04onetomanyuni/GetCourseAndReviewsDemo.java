package com.mami.luv2codes.hibernate.tutorial.hb04onetomanyuni;

import com.mami.luv2codes.hibernate.tutorial.entity.Course;
import com.mami.luv2codes.hibernate.tutorial.entity.Instructor;
import com.mami.luv2codes.hibernate.tutorial.entity.InstructorDetail;
import com.mami.luv2codes.hibernate.tutorial.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewsDemo {

    public static void main(String[] args) {

        //Create session factory

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        //Create session
        Session session = factory.getCurrentSession();

        try {

            //Start a transaction

            session.beginTransaction();

            //get the course

            int theId =10; // id taked from db
            Course tempCourse = session.get(Course.class, theId); // Course is now in the memory

            //delete the course
            session.delete(tempCourse); // wil delete from db , remember


            //Commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }


        finally {

            factory.close();
        }
    }
}
