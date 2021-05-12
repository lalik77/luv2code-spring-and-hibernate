package com.mami.luv2codes.hibernate.tutorial.hb03onetomany;

import com.mami.luv2codes.hibernate.tutorial.entity.Course;
import com.mami.luv2codes.hibernate.tutorial.entity.Instructor;
import com.mami.luv2codes.hibernate.tutorial.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCourseDemo {

    public static void main(String[] args) {

        //Create session factory

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        //Create session
        Session session = factory.getCurrentSession();

        try {

            //Start a transaction

            session.beginTransaction();

            int theId=1;

            Instructor retrievedInstructor = session.get(Instructor.class,theId);

            System.out.println( "Instructor " + retrievedInstructor);

            //get course for the instructor

            System.out.println(retrievedInstructor.getCourseList());

            //Commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }


        finally {

            factory.close();
        }
    }
}
