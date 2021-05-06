package com.mami.luv2codes.hibernate.tutorial.hb01onetooneuni;

import com.mami.luv2codes.hibernate.tutorial.entity.Instructor;
import com.mami.luv2codes.hibernate.tutorial.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDemo {

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

            //get instructor by primary key / id

            int id=1;

            Instructor instructorTemp = session.get(Instructor.class, id);

            //delete the instructor

            if ( instructorTemp != null) {

                System.out.println("Deleting Instructor..." + " " + instructorTemp);

                //Note :will also delte the detail because yhe CascadeType.ALL
                session.delete(instructorTemp);
            }

            //Commit transaction

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {

            factory.close();
        }
    }
}
