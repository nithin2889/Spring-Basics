package io.playground.hibernate.demo.aop.aspects;

import io.playground.hibernate.demo.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

  // this is where we add all of our related advices for logging
  @Pointcut("execution(* io.playground.hibernate.demo.aop.*.*.*(..))")
  private void forDAOPackage() {}

  @Pointcut("execution(* io.playground.hibernate.demo.aop.*.*.get*(..))")
  private void getterMethods() {}

  @Pointcut("execution(* io.playground.hibernate.demo.aop.*.*.set*(..))")
  private void setterMethods() {}

  @Pointcut("forDAOPackage() && !(getterMethods() || setterMethods())")
  private void forDAOPackageNoGetterOrSetter() {}

  // @Before advice
  @Before("forDAOPackageNoGetterOrSetter()")
  public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
    System.out.println("\n====> executing @Before advice on addAccount()");

    // display method signature
    MethodSignature signature = (MethodSignature) theJoinPoint.getSignature();
    System.out.println("Method: " + signature.getMethod());

    // display method arguments
    Object[] args = theJoinPoint.getArgs();
    System.out.println("Arguments passed are: ");
    for (Object arg : args) {
      System.out.println(arg);

      if (arg instanceof Account) {
        Account theAccount = (Account) arg;

        System.out.println("Name: " + theAccount.getName());
        System.out.println("Level: " + theAccount.getLevel());
      }
    }
  }

  @Before("forDAOPackageNoGetterOrSetter()")
  public void performApiAnalytics() {
    System.out.println("\n====> executing @Before advice to performApiAnalytics on addAccount()");
  }

  @Before("forDAOPackageNoGetterOrSetter()")
  public void logToCloudAsync() {
    System.out.println("\n====> executing @Before advice to logToCloudAsync on addAccount()");
  }
}
