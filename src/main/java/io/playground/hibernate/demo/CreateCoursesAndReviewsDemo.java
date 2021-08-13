package io.playground.hibernate.demo;

import io.playground.hibernate.demo.entity.Course;
import io.playground.hibernate.demo.entity.Instructor;
import io.playground.hibernate.demo.entity.InstructorDetail;
import io.playground.hibernate.demo.entity.Review;
import io.playground.hibernate.demo.util.Utils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndReviewsDemo {

  public static void main(String[] args) {
    // create a session factory
    SessionFactory sessionFactory =
        new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Instructor.class)
            .addAnnotatedClass(InstructorDetail.class)
            .addAnnotatedClass(Course.class)
            .addAnnotatedClass(Review.class)
            .buildSessionFactory();

    // create a session
    Session session = Utils.getSession(sessionFactory);

    try {
      // start a transaction
      session.beginTransaction();

      // create a course
      Course course1 = new Course("React Native");

      // add some reviews
      Review review1 = new Review("Great course!");
      Review review2 = new Review("Average course!");
      Review review3 = new Review("Worst course!");

      // save the course ... and leverage the cascade all
      course1.add(review1);
      course1.add(review2);
      course1.add(review3);

      // save course, will save reviews too.
      System.out.println("Saving course...");
      System.out.println(course1 + "\n");
      System.out.println(course1.getReviews() + "\n");

      session.save(course1);

      session.getTransaction().commit();
      System.out.println("Transaction completed...");
    } finally {
      sessionFactory.close();
      session.close();
    }
  }
}
