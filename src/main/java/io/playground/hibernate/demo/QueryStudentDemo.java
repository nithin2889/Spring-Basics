package io.playground.hibernate.demo;

import io.playground.hibernate.demo.entity.Student;
import io.playground.hibernate.demo.util.Utils;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class QueryStudentDemo {

  public static void main(String[] args) {
    // create a session factory
    SessionFactory sessionFactory = Utils.getSessionFactory(Student.class);

    // create a session
    Session session = Utils.getSession(sessionFactory);

    try {
      // start a transaction
      session.beginTransaction();

      // query for students
      List<Student> students =
          session.createQuery("from Student").getResultList();

      // display the students
      System.out.println("Students list:");
      displayStudents(students);

      students =
          session.createQuery("from Student s where s.lastName = 'Prasad'").getResultList();

      // display the students
      System.out.println("\nStudents list with last name:");
      displayStudents(students);

      students =
          session.createQuery("from Student s where s.lastName = 'Pras' or s.firstName = 'Adelina'").getResultList();

      // display the students
      System.out.println("\nStudents list with first name or last name:");
      displayStudents(students);

      students =
          session.createQuery("from Student s where s.email like '%yahoo.com'").getResultList();

      // display the students
      System.out.println("\nStudents list with email that has yahoo.com:");
      displayStudents(students);

      // commit transaction
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
