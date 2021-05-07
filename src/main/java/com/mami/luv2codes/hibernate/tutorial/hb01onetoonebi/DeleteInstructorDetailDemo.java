package com.mami.luv2codes.hibernate.tutorial.hb01onetoonebi;

import com.mami.luv2codes.hibernate.tutorial.entity.Instructor;
import com.mami.luv2codes.hibernate.tutorial.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

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

            //Start a transaction
            session.beginTransaction();

            //Get InstructorDetail object

            int theId=2;
            InstructorDetail instructorDetailTemp =
                    session.get(InstructorDetail.class,theId);


            //Print the Instructor detail object

            System.out.println("InstructorDetail with id = "
                    + theId + " -> "
                    + instructorDetailTemp);

            //Print the associate instructor

            Instructor instructorTemp = instructorDetailTemp.getInstructor();

            System.out.println("Instructor associated to InstructorDetail with id="
                    + theId + "->"
                    + instructorTemp);

            //let's delete the instructor detail

            System.out.println("Deleting InstructorDetail with id="
                    + theId
                    + "->"
                    + instructorDetailTemp);

            session.delete(instructorDetailTemp);


            //Commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        finally {

            session.close();
            factory.close();
        }
    }
}
