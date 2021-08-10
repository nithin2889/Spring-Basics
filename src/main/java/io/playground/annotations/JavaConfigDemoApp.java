package io.playground.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

  public static void main(String[] args) {
    // read spring config Java class
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(SportConfig.class);

    // get the bean from the spring container
    Coach thatTennisCoach = context.getBean("tennisCoach", Coach.class);

    // call a method on the bean
    System.out.println(thatTennisCoach.getDailyWorkout());

    // close the context
    context.close();
  }
}
