package io.playground.hibernate.demo;

import io.playground.hibernate.demo.entity.Instructor;
import io.playground.hibernate.demo.entity.InstructorDetail;
import io.playground.hibernate.demo.util.Utils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

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
      Instructor instructor1 = new Instructor("Nithin", "Prasad", "nithin.p@amazon.com");
      InstructorDetail instructorDetail1 =
          new InstructorDetail("https://youtube.com/nithin.prasad", "Cricket");

      Instructor instructor2 = new Instructor("Akhila", "Martia", "akhila.m@amazon.com");
      InstructorDetail instructorDetail2 =
          new InstructorDetail("https://youtube.com/akhila.martia", "Sitting");

      instructor1.setInstructorDetail(instructorDetail1);
      instructor2.setInstructorDetail(instructorDetail2);

      // start a transaction
      session.beginTransaction();

      session.save(instructor1);
      session.save(instructor2);

      // commit the transaction
      System.out.println("Saving instructor...\n" + instructor1);
      System.out.println("Saving instructor...\n" + instructor2);

      session.getTransaction().commit();
      System.out.println("Transaction completed...");
    } finally {
      sessionFactory.close();
    }
  }
}
