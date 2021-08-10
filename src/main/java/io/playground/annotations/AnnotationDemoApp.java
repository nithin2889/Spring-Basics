package io.playground.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

  public static void main(String[] args) {
    // read spring config file
    ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext("springannotations-applicationContext.xml");

    // get the bean from the spring container
    Coach thatTennisCoach = context.getBean("tennisCoach", Coach.class);

    // call a method on the bean
    System.out.println(thatTennisCoach.getDailyWorkout());

    // close the context
    context.close();
  }
}
