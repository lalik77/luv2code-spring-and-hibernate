package com.mami.luv2codes.hibernate.tutorial.hb03onetomany;

import com.mami.luv2codes.hibernate.tutorial.entity.Course;
import com.mami.luv2codes.hibernate.tutorial.entity.Instructor;
import com.mami.luv2codes.hibernate.tutorial.entity.InstructorDetail;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchJoinDemo {

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

            //Option 2 :Hibernate query with HQL
            int theId=1;
            Query<Instructor> query = session.createQuery("select i from Instructor i " +
                                                                "JOIN FETCH i.courseList " +
                                                                "where i.id=:theInstructorId"
                                                                ,Instructor.class);

            //set parameter on query
            query.setParameter("theInstructorId",theId);

            //execute the query and get instructor

            Instructor retrievedInstructor = query.getSingleResult();

            System.out.println( "\nLuv2 code : Instructor " + retrievedInstructor);


            //Commit transaction

            session.getTransaction().commit();



            //close session
            session.close();

            System.out.println("The session is now closed !");

            //get course for the instructor

            System.out.println(retrievedInstructor.getCourseList());

            System.out.println("Done!");
        }
        finally {

            factory.close();
        }
    }
}
