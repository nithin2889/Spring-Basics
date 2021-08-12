package io.playground.hibernate.demo;

import io.playground.hibernate.demo.entity.Student;
import io.playground.hibernate.demo.util.Utils;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateStudentDemo {

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

      // updating a student
      myStudent.setEmail("notnotnithin@me.com");
      // int updatedStudent = session.createQuery("from Student").executeUpdate();

      // commit transaction
      session.getTransaction().commit();

      // Bulk update
      session = Utils.getSession(sessionFactory);
      session.beginTransaction();

      // update email for all the students
      session.createQuery("update Student set email = 'foobar@me.com'")
          .executeUpdate();

      session.getTransaction().commit();
      System.out.println("Transaction completed...");
    } finally {
      sessionFactory.close();
    }
  }

  private static void displayStudents(List<Student> students) {
    students.forEach(System.out::println);
  }
}
