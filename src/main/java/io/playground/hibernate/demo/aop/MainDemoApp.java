package io.playground.hibernate.demo.aop;

import io.playground.hibernate.demo.aop.config.DemoConfig;
import io.playground.hibernate.demo.aop.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

  public static void main(String[] args) {
    // read the spring config
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(DemoConfig.class);

    // get the bean from spring container
    AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

    // call the business method
    theAccountDAO.addAccount();

    // calling again
    System.out.println("\ncalling again\n");
    theAccountDAO.addAccount();

    // close the context
    context.close();
  }
}
