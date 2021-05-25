package com.mami.luv2codes.hibernate.tutorial.hb05manytomany;

import com.mami.luv2codes.hibernate.tutorial.entity.Course;
import com.mami.luv2codes.hibernate.tutorial.entity.Instructor;
import com.mami.luv2codes.hibernate.tutorial.entity.InstructorDetail;
import com.mami.luv2codes.hibernate.tutorial.entity.Review;
import com.mami.luv2codes.hibernate.tutorial.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCoursesDemo {

    public static void main(String[] args) {

        //Create session factory

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //Create session
        Session session = factory.getCurrentSession();

        try {


            //Start a transaction

            session.beginTransaction();

            //Get the course from db to memeory

            int courseId = 10;

            Course course = session.get(Course.class, courseId);

            //Delete the course
            System.out.println("\nDeleting the course " + course + "\n");

            session.delete(course);





            //Commit transaction

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {

            factory.close();
        }
    }
}
