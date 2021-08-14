package io.playground.hibernate.demo.aop;

import io.playground.hibernate.demo.aop.config.DemoConfig;
import io.playground.hibernate.demo.aop.dao.AccountDAO;
import io.playground.hibernate.demo.aop.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

  public static void main(String[] args) {
    // read the spring config
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(DemoConfig.class);

    // get the bean from spring container
    AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
    MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

    // call the business method
    Account acc1 = new Account();
    acc1.setLevel("1");
    acc1.setName("Savings");

    // call the account dao getter and setter
    theAccountDAO.setName("foobar");
    theAccountDAO.setServiceCode("gold");

    String name = theAccountDAO.getName();
    String serviceCode = theAccountDAO.getServiceCode();

    theAccountDAO.addAccount(acc1, true, false);
    theAccountDAO.doWork();

    theMembershipDAO.addAccount();
    theMembershipDAO.goToSleep();

    // close the context
    context.close();
  }
}
