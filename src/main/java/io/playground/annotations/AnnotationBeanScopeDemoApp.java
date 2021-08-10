package io.playground.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

  public static void main(String[] args) {
    // load spring configuration file
    ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext("springannotations-applicationContext.xml");

    // retrieve the bean from the Spring container
    Coach myCoach = context.getBean("tennisCoach", Coach.class);
    Coach myAlphaCoach = context.getBean("tennisCoach", Coach.class);

    // check if they are the same
    boolean result = (myCoach == myAlphaCoach);
    System.out.println("Pointing to the same object: " + result);
    System.out.println("Memory location of myCoach: " + myCoach);
    System.out.println("Memory location of myAlphaCoach: " + myAlphaCoach);

    // close the context
    context.close();
  }
}
