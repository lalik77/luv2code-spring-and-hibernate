package com.mami.luv2codes.hibernate.tutorial.hb05manytomany;

import com.mami.luv2codes.hibernate.tutorial.entity.Course;
import com.mami.luv2codes.hibernate.tutorial.entity.Instructor;
import com.mami.luv2codes.hibernate.tutorial.entity.InstructorDetail;
import com.mami.luv2codes.hibernate.tutorial.entity.Review;
import com.mami.luv2codes.hibernate.tutorial.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {

    public static void main(String[] args) {

        //Create session factory

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //Create session
        Session session = factory.getCurrentSession();

        try {


            //Start a transaction

            session.beginTransaction();

            // Create a course in memory

            Course tempCourse = new Course("Pacman - How ...");

            //save course

            System.out.println(" Saving the course");
            System.out.println(tempCourse);
            session.save(tempCourse);



            //Create the students
            Student tempStudent1 = new Student("John","Doe","jo@nnm.com");
            Student tempStudent2 = new Student("Asd","Davi","davi@nnm.com");
            Student tempStudent3 = new Student("Lsd12","Erto","erto@nnm.com");

            //add students to the course
            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent3);

            //save the students

            System.out.println("\nSaving students");

            session.save(tempStudent1);
            session.save(tempStudent3);

            //Commit transaction

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {

            factory.close();
        }
    }
}
