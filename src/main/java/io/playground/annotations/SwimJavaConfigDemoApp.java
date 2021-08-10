package io.playground.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

  public static void main(String[] args) {
    // read spring config Java class
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(SportConfig.class);

    // get the bean from the spring container
    SwimCoach thatSwimCoach = context.getBean("swimCoach", SwimCoach.class);

    // call a method on the bean
    System.out.println(thatSwimCoach.getDailyWorkout());
    System.out.println(thatSwimCoach.getDailyFortune());

    System.out.println("Email: " + thatSwimCoach.getEmail());
    System.out.println("Team: " + thatSwimCoach.getTeam());

    // close the context
    context.close();
  }
}
