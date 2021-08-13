package io.playground.hibernate.demo;

import io.playground.hibernate.demo.entity.Course;
import io.playground.hibernate.demo.entity.Instructor;
import io.playground.hibernate.demo.entity.InstructorDetail;
import io.playground.hibernate.demo.entity.Review;
import io.playground.hibernate.demo.entity.Student;
import io.playground.hibernate.demo.util.Utils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndStudentsDemo {

  public static void main(String[] args) {
    // create a session factory
    SessionFactory sessionFactory =
        new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .addAnnotatedClass(Course.class)
            .addAnnotatedClass(Review.class)
            .addAnnotatedClass(Student.class)
            .buildSessionFactory();

    // create a session
    Session session = Utils.getSession(sessionFactory);

    try {
      // start a transaction
      session.beginTransaction();

      // create a course
      Course course = new Course("Git and GitHub");

      // save the course ... and leverage the cascade all
      System.out.println("\nSaving the course");
      session.save(course);
      System.out.println("\nSaved course: " + course + "\n");

      // Create students
      Student st1 = new Student("Nithin", "Prasad", "nithin@gmail.com");
      Student st2 = new Student("Akhila", "Martia", "akhila@yahoo.com");
      Student st3 = new Student("Ariana", "Brie", "ariana.b@hotmail.com");
      Student st4 = new Student("Adelina", "Cheryl", "adelina@gmail.com");

      course.addStudent(st1);
      course.addStudent(st2);
      course.addStudent(st3);
      course.addStudent(st4);

      System.out.println("\nSaving students\n");
      session.save(st1);
      session.save(st2);
      session.save(st3);
      session.save(st4);
      System.out.println("\nSaved students\n");

      session.getTransaction().commit();
      System.out.println("Transaction completed...");
    } finally {
      sessionFactory.close();
      session.close();
    }
  }
}
