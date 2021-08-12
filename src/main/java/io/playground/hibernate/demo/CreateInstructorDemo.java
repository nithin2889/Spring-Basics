package io.playground.hibernate.demo;

import io.playground.hibernate.demo.entity.Course;
import io.playground.hibernate.demo.entity.Instructor;
import io.playground.hibernate.demo.entity.InstructorDetail;
import io.playground.hibernate.demo.util.Utils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

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
      Instructor instructor1 = new Instructor("Ariana", "Brie", "ariana.b@google.com");
      InstructorDetail instructorDetail1 =
          new InstructorDetail("https://youtube.com/ariana.b", "Gamer");

      instructor1.setInstructorDetail(instructorDetail1);

      // start a transaction
      session.beginTransaction();

      instructor1.setInstructorDetail(instructorDetail1);

      // commit the transaction
      System.out.println("Saving instructor...\n" + instructor1);

      session.save(instructor1);
      session.getTransaction().commit();
      System.out.println("Transaction completed...");
    } finally {
      session.close();
      sessionFactory.close();
    }
  }
}
