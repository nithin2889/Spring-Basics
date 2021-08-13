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

public class AddCoursesForStudentDemo {

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

      Student student1 = session.get(Student.class, 1);
      System.out.println("\nFetched student: \n" + student1 + "\n");
      System.out.println("\nStudent is assigned with: \n" + student1.getCourses() + "\n");

      // creating courses
      Course course1 = new Course("Spring Microservices");
      Course course2 = new Course("NodeJS");
      Course course3 = new Course("Angular");

      // adding student to courses
      course1.addStudent(student1);
      course2.addStudent(student1);
      course3.addStudent(student1);

      System.out.println("\nSaving the courses\n");

      // saving the courses
      session.save(course1);
      session.save(course2);
      session.save(course3);

      session.getTransaction().commit();
      System.out.println("Transaction completed...");
    } finally {
      sessionFactory.close();
      session.close();
    }
  }
}
