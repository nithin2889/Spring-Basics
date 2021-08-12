package io.playground.hibernate.demo;

import io.playground.hibernate.demo.entity.Course;
import io.playground.hibernate.demo.entity.Instructor;
import io.playground.hibernate.demo.entity.InstructorDetail;
import io.playground.hibernate.demo.util.Utils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

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

      // Option 2: Hibernate query with HQL
      Query<Instructor> query =
          session.createQuery(
              "select i from Instructor i "
                  + "join fetch i.courses "
                  + "where i.id = :theInstructorId",
              Instructor.class);
      query.setParameter("theInstructorId", 5);

      // execute the query and get instructor
      Instructor instructor = query.getSingleResult();

      System.out.println("instructor: " + instructor);

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
