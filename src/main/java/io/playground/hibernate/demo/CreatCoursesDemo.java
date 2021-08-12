package io.playground.hibernate.demo;

import io.playground.hibernate.demo.entity.Course;
import io.playground.hibernate.demo.entity.Instructor;
import io.playground.hibernate.demo.entity.InstructorDetail;
import io.playground.hibernate.demo.util.Utils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreatCoursesDemo {

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

      Course coursesOffered1 = new Course("Java");
      Course coursesOffered2 = new Course("Spring");
      Course coursesOffered3 = new Course("Hibernate");
      Course coursesOffered4 = new Course("React");

      instructor.add(coursesOffered1);
      instructor.add(coursesOffered2);
      instructor.add(coursesOffered3);
      instructor.add(coursesOffered4);

      // saving course will in turn save instructor details.
      session.save(coursesOffered1);
      session.save(coursesOffered2);
      session.save(coursesOffered3);
      session.save(coursesOffered4);

      session.getTransaction().commit();
      System.out.println("Transaction completed...");
    } finally {
      sessionFactory.close();
      session.close();
    }
  }
}
