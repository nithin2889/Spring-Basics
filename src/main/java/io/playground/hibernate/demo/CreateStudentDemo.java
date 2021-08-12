package io.playground.hibernate.demo;

import io.playground.hibernate.demo.entity.Student;
import io.playground.hibernate.demo.util.Utils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

  public static void main(String[] args) {
    // create a session factory
    SessionFactory sessionFactory = Utils.getSessionFactory(Student.class);

    // create a session
    Session session = Utils.getSession(sessionFactory);

    try {
      // create a student object
      System.out.println("Create new student object...");
      Student student1 = new Student("Nithin", "Prasad", "nithin@gmail.com");

      // start a transaction
      session.beginTransaction();

      // save the Student object
      System.out.println("Saving the student...");
      session.save(student1);

      // commit the transaction
      session.getTransaction().commit();
      System.out.println("Transaction completed...");
    } finally {
      sessionFactory.close();
    }
  }


}
