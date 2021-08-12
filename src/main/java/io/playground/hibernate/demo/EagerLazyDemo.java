package io.playground.hibernate.demo;

import io.playground.hibernate.demo.entity.Course;
import io.playground.hibernate.demo.entity.Instructor;
import io.playground.hibernate.demo.entity.InstructorDetail;
import io.playground.hibernate.demo.util.Utils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyDemo {

  public static void main(String[] args) {
    // create a session factory
    SessionFactory sessionFactory =
        new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .addAnnotatedClass(Course.class)
            .buildSessionFactory();

    // create a session
    Session session = Utils.getSession(sessionFactory);

    try {
      // start a transaction
      session.beginTransaction();

      Instructor instructor = session.get(Instructor.class, 5);

      // Option 1: Call the getter method before closing the session. This will have the data loaded in the memory
      // and it doesn't matter if we close the session and try to query for the courses data. As this time,
      // the data is already in the memory.
      // System.out.println("fetched instructor: " + instructor + "\n");
      System.out.println("courses: " + instructor.getCourses() + "\n");
      session.getTransaction().commit();

      session.close();

      System.out.println("\nThe session is now closed!\n");
      System.out.println("\ncourses: " + instructor.getCourses() + "\n");
      System.out.println("\nTransaction completed...\n");
    } finally {
      sessionFactory.close();
      session.close();
    }
  }
}
