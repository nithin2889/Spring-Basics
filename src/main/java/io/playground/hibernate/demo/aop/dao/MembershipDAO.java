package io.playground.hibernate.demo.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

  public String addAccount() {
    System.out.println(getClass() + ": Doing good stuff. Adding a membership account!");
    return "account added";
  }

  public void goToSleep() {
    System.out.println(getClass() + ": I am going to sleep now!! \n");
  }
}
