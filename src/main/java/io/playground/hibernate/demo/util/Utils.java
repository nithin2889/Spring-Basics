package io.playground.hibernate.demo.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Utils {

  public static SessionFactory getSessionFactory(Class className) {
    return new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(className)
        .buildSessionFactory();
  }

  public static Session getSession(SessionFactory sessionFactory) {
    return sessionFactory.getCurrentSession();
  }
}
