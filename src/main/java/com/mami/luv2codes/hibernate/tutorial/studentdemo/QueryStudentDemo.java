package com.mami.luv2codes.hibernate.tutorial.studentdemo;

import com.mami.luv2codes.hibernate.tutorial.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
           //start transaction
            session.beginTransaction();

            //query students
            List<Student> student = session.createQuery("from Student").list();


            //dispaly student
            System.out.println("Query all Students");

            displayStudents(student);

            //query student : last name = 'Ivanov'
            System.out.println("\n");

            student=session.createQuery("from Student s where s.lastName='Ivanov' ").list();

            //display student Ivanov
            System.out.println("Query student : last name = 'Ivanov'");

            displayStudents(student);

            //query student : last name = 'Ivanov' Or first name = 'Eve'
            System.out.println("\n");

            student=session.createQuery("from Student s where s.lastName='Ivanov' OR s.firstName='Eve' ").list();

            System.out.println("Query student : last name = 'Ivanov' Or first name = 'Eve'");
            displayStudents(student);


            //query student with email Like '%luv2code'
            System.out.println("\n");

            student = session.createQuery("from Student s where s.email LIKE '%mail.com'").getResultList();

            displayStudents(student);


            //commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");



        }
        finally {

            factory.close();
        }
    }

    private static void displayStudents(List<Student> student) {
        for (Student s : student) {

            System.out.println(s);

        }
    }
}
