package com.mami.luv2codes.hibernate.tutorial.hb04onetomanyuni;

import com.mami.luv2codes.hibernate.tutorial.entity.Course;
import com.mami.luv2codes.hibernate.tutorial.entity.Instructor;
import com.mami.luv2codes.hibernate.tutorial.entity.InstructorDetail;
import com.mami.luv2codes.hibernate.tutorial.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {

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

            // Create a course in memory

            Course tempCourse = new Course("Pacman - How ...");

            //add some reviews in memory
            tempCourse.addReview(new Review("Very good .... love it"));
            tempCourse.addReview(new Review("Cool .... very nice"));
            tempCourse.addReview(new Review("Fine .... love it"));

            //save course ... and leverage the cascade all - pass from memory to db

            System.out.println(" Saving the course");
            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviews());
            session.save(tempCourse);









            //Commit transaction

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {

            factory.close();
        }
    }
}
