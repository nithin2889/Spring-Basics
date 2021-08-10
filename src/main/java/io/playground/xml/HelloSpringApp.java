package io.playground.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

  public static void main(String[] args) {
    // load the spring config file
    ClassPathXmlApplicationContext xmlApplicationContext =
        new ClassPathXmlApplicationContext("applicationContext.xml");

    // retrieve a bean from spring container
    Coach myCoach = xmlApplicationContext.getBean("myCoach", Coach.class);
    CricketCoach myCricketCoach = xmlApplicationContext.getBean("myCricketCoach", CricketCoach.class);

    // call methods on the bean
    myCoach.intro();

    myCricketCoach.intro();
    System.out.println(myCricketCoach.getEmail());
    System.out.println(myCricketCoach.getTeam());

    // close the context
    xmlApplicationContext.close();
  }
}
