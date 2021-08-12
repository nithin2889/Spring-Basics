package io.playground.hibernate.demo;

import io.playground.hibernate.demo.entity.Student;
import io.playground.hibernate.demo.util.Utils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ReadStudentDemo {

  public static void main(String[] args) {
    // create a session factory
    SessionFactory sessionFactory = Utils.getSessionFactory(Student.class);

    // create a session
    Session session = Utils.getSession(sessionFactory);

    try {
      // create a student object
      System.out.println("Creating student object...");
      Student student1 = new Student("Nithin", "Prasad", "nithin@gmail.com");

      // start a transaction
      session.beginTransaction();

      // save the Student object
      System.out.println("Saving the student...");
      System.out.println(student1);
      session.save(student1);

      // commit the transaction
      session.getTransaction().commit();

      // Code to retrieve student
      // find out the student's id: primary key
      System.out.println("Saved student. Generated id: " + student1.getId());

      // get a new session again and start the transaction
      sessionFactory = Utils.getSessionFactory(Student.class);
      session = Utils.getSession(sessionFactory);

      // start a transaction
      session.beginTransaction();

      System.out.println("Getting student with id: " + student1.getId());
      Student studentResult = session.get(Student.class, student1.getId());

      if (studentResult != null) {
        System.out.println("Result retrieved:\n" + studentResult);
      } else {
        System.out.println("Data not found!");
      }
      session.getTransaction().commit();

      System.out.println("Transaction completed...");
    } finally {
      sessionFactory.close();
    }
  }
}
