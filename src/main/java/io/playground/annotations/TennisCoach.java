package io.playground.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
// @Scope("prototype")
public class TennisCoach implements Coach {

  @Value("${ipl.email}")
  private String email;

  @Value("${ipl.team}")
  private String team;

  // 4. Field Injection
  /*@Autowired
  @Qualifier("restFortuneService")*/
  private FortuneService fortuneService;

  // 2. Setter Method Injection
  /*@Autowired
  @Qualifier("randomFortuneService")
  public void setFortuneService(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }*/

  // 3. Method Injection (Can inject dependency using any random method)
  /*@Autowired
  @Qualifier("databaseFortuneService")
  public void doSomeInjection(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }*/

  /**
   * As of Spring Framework 4.3, an @Autowired annotation on such a constructor is no longer
   * necessary if the target bean only defines one constructor to begin with. However, if several
   * constructors are available, at least one must be annotated to teach the container which one to
   * use.
   */
  // 1. Constructor Injection
  @Autowired
  public TennisCoach(@Qualifier("happyFortuneService") FortuneService fortuneService) {
    System.out.println("TennisCoach: inside constructor");
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Practice your backend volley. " + getDailyFortune() + " " + email + " " + team;
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

  // Code will execute after constructor and after injection of dependencies
  @PostConstruct
  public void init() {
    System.out.println("Initializing bean...");
  }

  // Code will execute before bean is destroyed
  @PreDestroy
  public void destroy() {
    System.out.println("Destroying bean!!!");
  }
}
