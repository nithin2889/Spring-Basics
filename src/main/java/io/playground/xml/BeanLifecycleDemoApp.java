package io.playground.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecycleDemoApp {

  public static void main(String[] args) {
    // load the spring config file
    ClassPathXmlApplicationContext xmlApplicationContext =
        new ClassPathXmlApplicationContext("beanLifecycle-applicationContext.xml");

    // retrieve a bean from spring container
    Coach myCoach = xmlApplicationContext.getBean("myCoach", Coach.class);
    System.out.println(myCoach.fortune());

    // close the context
    xmlApplicationContext.close();
  }
}
