package io.playground.hibernate.demo;

import io.playground.hibernate.demo.entity.Instructor;
import io.playground.hibernate.demo.entity.InstructorDetail;
import io.playground.hibernate.demo.util.Utils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

  public static void main(String[] args) {
    // create a session factory
    SessionFactory sessionFactory =
        new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .buildSessionFactory();

    // create a session
    Session session = Utils.getSession(sessionFactory);

    try {
      // start a transaction
      session.beginTransaction();

      Instructor instructor1 = session.get(Instructor.class, 1);
      System.out.println("Found instructor: \n" + instructor1);

      if (instructor1 != null) {
        System.out.println("Deleting: \n" + instructor1);
        session.delete(instructor1);
      } else {
        System.out.println("Instructor not found!");
      }

      session.getTransaction().commit();
      System.out.println("Transaction completed...");
    } finally {
      sessionFactory.close();
    }
  }
}
