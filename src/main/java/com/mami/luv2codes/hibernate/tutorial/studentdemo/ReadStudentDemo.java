package com.mami.luv2codes.hibernate.tutorial.studentdemo;

import com.mami.luv2codes.hibernate.tutorial.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating a new student object...");

            Student studentTemp = new Student("Samir", "Meziane", "smeziane@mail.ru");

            session.beginTransaction();

            System.out.println("Saving the student...");
            System.out.println(studentTemp);

            session.save(studentTemp);

            session.getTransaction().commit();

            // find student's id:primary key

            System.out.println("\nSaved student with Generated id : " + studentTemp.getId());

            //now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();

            //retrieve student based on the id:primary key

            System.out.println("\nRetrieved student from db with id : " + studentTemp.getId());

            Student studentToRetrieve = session.get(Student.class,studentTemp.getId());

            System.out.println("Get complete: " + studentToRetrieve);

            //commit transaction
            session.getTransaction().commit();







            System.out.println("Done!");
        }
        finally {

            factory.close();
        }
    }
}
