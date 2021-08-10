package io.playground.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

  public static void main(String[] args) {
    // load the spring config file
    ClassPathXmlApplicationContext xmlApplicationContext =
        new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

    // retrieve a bean from spring container
    Coach myCoach = xmlApplicationContext.getBean("myCoach", Coach.class);
    Coach myAlphaCoach = xmlApplicationContext.getBean("myCoach", Coach.class);

    // print out the results
    boolean result = myCoach == myAlphaCoach;
    System.out.println("\nPointing to the same object: " + result);
    System.out.println("\nMemory location for myCoach: " + myCoach);
    System.out.println("\nMemory location for myAlphaCoach: " + myAlphaCoach);

    // close the context
    xmlApplicationContext.close();
  }
}
