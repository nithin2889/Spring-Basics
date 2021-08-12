package io.playground.hibernate.demo;

import io.playground.hibernate.demo.entity.Student;
import io.playground.hibernate.demo.util.Utils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class PrimaryKeyDemo {

  public static void main(String[] args) {
    // create a session factory
    SessionFactory sessionFactory = Utils.getSessionFactory(Student.class);

    // create a session
    Session session = Utils.getSession(sessionFactory);

    try {
      // create a student object
      System.out.println("Create 4 student object...");
      Student student1 = new Student("Nithin", "Prasad", "nithin@gmail.com");
      Student student2 = new Student("Akhila", "Martia", "akhila@gmail.com");
      Student student3 = new Student("Ariana", "Brie", "ariana@gmail.com");
      Student student4 = new Student("Adelina", "Cheryl", "adelina@gmail.com");

      // start a transaction
      session.beginTransaction();

      // save the Student object
      System.out.println("Saving the student...");
      session.save(student1);
      session.save(student2);
      session.save(student3);
      session.save(student4);

      // commit the transaction
      session.getTransaction().commit();
      System.out.println("Transaction completed...");
    } finally {
      sessionFactory.close();
    }
  }
}
