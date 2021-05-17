package com.mami.luv2codes.hibernate.tutorial.hb04onetomanyuni;

import com.mami.luv2codes.hibernate.tutorial.entity.Course;
import com.mami.luv2codes.hibernate.tutorial.entity.Instructor;
import com.mami.luv2codes.hibernate.tutorial.entity.InstructorDetail;
import com.mami.luv2codes.hibernate.tutorial.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseAndReviewsDemo {

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

            //get a course from db

            int theId = 10; // id is taken from  db
            Course retrievedCourse = session.get(Course.class, theId);

            System.out.println("Retrived course " + retrievedCourse); // in memory


            // delete this course
            System.out.println("Deleting course from db"); // remember fetch was setup
                                                           // for cascading type all ->
                                                           // it will also delete reviews

            session.delete(retrievedCourse);

            //Commit transaction

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {

            factory.close();
        }
    }
}
