package io.playground.hibernate.demo;

import io.playground.hibernate.demo.entity.Instructor;
import io.playground.hibernate.demo.entity.InstructorDetail;
import io.playground.hibernate.demo.util.Utils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

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

      InstructorDetail instructorDetail = session.get(InstructorDetail.class, 4);
      System.out.println("Instructor Detail: \n" + instructorDetail);

      System.out.println("Deleting instructor and all his details information: \n");
      // remove the associated object reference
      // break bidirectional link
      instructorDetail.getInstructor().setInstructorDetail(null);
      session.delete(instructorDetail);

      session.getTransaction().commit();
      System.out.println("Transaction completed...");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
      sessionFactory.close();
    }
  }
}
