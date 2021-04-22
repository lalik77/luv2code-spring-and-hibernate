package com.mami.luv2codes.hibernate.tutorial;

import com.mami.luv2codes.hibernate.tutorial.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {


    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating 3 students object...");

            Student studentTemp1 = new Student("Eve", "Long", "eved@franctv.com");
            Student studentTemp2 = new Student("Luda", "Double", "luda@mail.com");
            Student studentTemp3 = new Student("Petr", "Ivanov", "ivanovd@gter.com");

            session.beginTransaction();

            System.out.println("Saving 3 students...");

            session.save(studentTemp1);
            session.save(studentTemp2);
            session.save(studentTemp3);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {

            factory.close();
        }
    }
}
