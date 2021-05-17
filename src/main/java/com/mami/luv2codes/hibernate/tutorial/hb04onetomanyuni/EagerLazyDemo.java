package com.mami.luv2codes.hibernate.tutorial.hb04onetomanyuni;

import com.mami.luv2codes.hibernate.tutorial.entity.Course;
import com.mami.luv2codes.hibernate.tutorial.entity.Instructor;
import com.mami.luv2codes.hibernate.tutorial.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

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

            System.out.println( "\nLuv2 code : Instructor " + retrievedInstructor);

            System.out.println("Loaded in memory while session is opened " + retrievedInstructor.getCourseList());


            //Commit transaction

            session.getTransaction().commit();



            //close session
            session.close();

            //get course for the instructor

            System.out.println(retrievedInstructor.getCourseList());

            System.out.println("Done!");
        }
        finally {

            factory.close();
        }
    }
}
