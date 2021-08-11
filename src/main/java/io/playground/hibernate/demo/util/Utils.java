package io.playground.hibernate.demo.util;

import io.playground.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utils {

  public static SessionFactory getSessionFactory() {
    return new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Student.class)
        .buildSessionFactory();
  }

  public static Session getSession(SessionFactory sessionFactory) {
    return sessionFactory.getCurrentSession();
  }
}
