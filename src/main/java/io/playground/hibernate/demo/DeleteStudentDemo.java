package io.playground.hibernate.demo;

import io.playground.hibernate.demo.entity.Student;
import io.playground.hibernate.demo.util.Utils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteStudentDemo {

  public static void main(String[] args) {
    // create a session factory
    SessionFactory sessionFactory = Utils.getSessionFactory(Student.class);

    // create a session
    Session session = Utils.getSession(sessionFactory);

    try {
      int studentId = 1;
      // start a transaction
      session.beginTransaction();

      System.out.println("Getting student with id: " + studentId);
      Student myStudent = session.get(Student.class, studentId);

      // delete the student
      System.out.println("Deleting student: " + myStudent);
      session.delete(myStudent);

      // delete student with id 2
      session.createQuery("delete from Student where id = 2").executeUpdate();

      // commit transaction
      session.getTransaction().commit();
      System.out.println("Transaction completed...");
    } finally {
      sessionFactory.close();
    }
  }
}
