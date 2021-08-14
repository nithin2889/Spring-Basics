package io.playground.hibernate.demo.aop.dao;

import io.playground.hibernate.demo.aop.Account;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class AccountDAO {

  private String name;
  private String serviceCode;

  public void addAccount(Account account, boolean isVIP, boolean isPrivateBanker) {
    System.out.println(getClass() + ": Doing my DB work. Adding an account! \n" + account);
    System.out.println("VIP? " + isVIP);
    System.out.println("Private Banker? " + isPrivateBanker);
  }

  public boolean doWork() {
    System.out.println(getClass() + ": Doing my work!! \n");
    return false;
  }
}
