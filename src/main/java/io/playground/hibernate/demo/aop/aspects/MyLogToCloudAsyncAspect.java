package io.playground.hibernate.demo.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyLogToCloudAsyncAspect {

  // this is where we add all of our related advices for logging
  @Pointcut("execution(* io.playground.hibernate.demo.aop.*.*.*(..))")
  private void forDAOPackage() {}

  @Pointcut("execution(* io.playground.hibernate.demo.aop.*.*.get*(..))")
  private void getterMethods() {}

  @Pointcut("execution(* io.playground.hibernate.demo.aop.*.*.set*(..))")
  private void setterMethods() {}

  @Pointcut("forDAOPackage() && !(getterMethods() || setterMethods())")
  private void forDAOPackageNoGetterOrSetter() {}

  @Before("forDAOPackageNoGetterOrSetter()")
  public void logToCloudAsync() {
    System.out.println("\n====> executing @Before advice to logToCloudAsync on addAccount()");
  }
}
