package com.mami.luv2codes.hibernate.tutorial;

import com.mami.luv2codes.hibernate.tutorial.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.List;

public class UpdateStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            //start transaction
            session.beginTransaction();

            //retrieve student based on the id : primary key
            int studentId=1;
            Student retrievedStudent = session.get(Student.class,studentId);

            System.out.println("Updating student...");
            retrievedStudent.setFirstName("Scooby");

            //commit transaction
            session.getTransaction().commit();


            //New code

            //Start another transaction

            session = factory.getCurrentSession();
            session.beginTransaction();


            //Update email for all students
            System.out.println("Update email for all students");

            session.createQuery("update Student set email='foo@gmail.com'")
                    .executeUpdate();


            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");








        }
        finally {

            factory.close();
        }
    }

}
