package com.mami.luv2codes.hibernate.tutorial.studentdemo;

import com.mami.luv2codes.hibernate.tutorial.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

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
            //Student retrievedStudent = session.get(Student.class,studentId);

           // System.out.println("Deleting student..." + retrievedStudent);

           // session.delete(retrievedStudent);

            //deleting student with id- 2
            System.out.println("Deleting with id = 2");

            session.createQuery("delete from Student where id=2")
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
