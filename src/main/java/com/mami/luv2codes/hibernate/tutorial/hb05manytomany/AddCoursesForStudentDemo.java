package com.mami.luv2codes.hibernate.tutorial.hb05manytomany;

import com.mami.luv2codes.hibernate.tutorial.entity.Course;
import com.mami.luv2codes.hibernate.tutorial.entity.Instructor;
import com.mami.luv2codes.hibernate.tutorial.entity.InstructorDetail;
import com.mami.luv2codes.hibernate.tutorial.entity.Review;
import com.mami.luv2codes.hibernate.tutorial.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForStudentDemo {

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

            //Get the student from db by id

            Student student = session.get(Student.class,3);

            System.out.println("\nLoaded student "
                    + student.getFirstName() + " " + student.getLastName() );

            System.out.println("Courses" + student.getCourses());

            //Create more course

            Course course1 = new Course("Databases");
            Course course2 = new Course("React");
            Course course3 = new Course("Angular");

            // add student to the course
            course1.addStudent(student);
            course2.addStudent(student);
            course3.addStudent(student);


            //save the courses
            System.out.println("Saving the courses");

            session.save(course1);
            session.save(course2);
            session.save(course3);


            //Commit transaction

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {

            factory.close();
        }
    }
}
