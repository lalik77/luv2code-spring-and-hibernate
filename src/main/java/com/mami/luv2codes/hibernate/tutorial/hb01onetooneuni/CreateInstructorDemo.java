package com.mami.luv2codes.hibernate.tutorial.hb01onetooneuni;

import com.mami.luv2codes.hibernate.tutorial.entity.Instructor;
import com.mami.luv2codes.hibernate.tutorial.entity.InstructorDetail;
import com.mami.luv2codes.hibernate.tutorial.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

    public static void main(String[] args) {

        //Create session factory

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        //Create session
        Session session = factory.getCurrentSession();

        try {

            //create the objects
            /*Instructor instructorTemp =
                    new Instructor("Alex","Mami","lalik77@inbox.ru");

            InstructorDetail instructorDetailtemp =
                    new InstructorDetail("laliklalikovic","fishing");*/

            Instructor instructorTemp =
                    new Instructor("Lalik","Mami","mami@inbox.ru");

            InstructorDetail instructorDetailtemp =
                    new InstructorDetail("mami alex","coding");



            //associate the objects

            instructorTemp.setInstructorDetail(instructorDetailtemp);

            //Start a transaction

            session.beginTransaction();

            //this also will save the details
            System.out.println("Saving instructor : " + instructorTemp);
            session.save(instructorTemp);

            //Commit transaction

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {

            factory.close();
        }
    }
}
