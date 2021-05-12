package com.mami.luv2codes.hibernate.tutorial.hb03onetomany;

import com.mami.luv2codes.hibernate.tutorial.entity.Course;
import com.mami.luv2codes.hibernate.tutorial.entity.Instructor;
import com.mami.luv2codes.hibernate.tutorial.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseDemo {

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

            //Create some courses

            Course tempCourse1 = new Course("1");
            Course tempCourse2 = new Course("2");
            Course tempCourse3 = new Course("3");

            //Add course to instructor
            retrievedInstructor.addCourse(tempCourse1);
            retrievedInstructor.addCourse(tempCourse2);

            //save the courses

            session.save(tempCourse1);
            session.save(tempCourse2);



            //Commit transaction

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {

            factory.close();
        }
    }
}
