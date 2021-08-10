package io.playground.annotations;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

  private FortuneService fortuneService;

  @Value("${ipl.email}")
  private String email;

  @Value("${ipl.team}")
  private String team;

  public SwimCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Swim 100 meters as a warm up";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

  public String getEmail() {
    return email;
  }

  public String getTeam() {
    return team;
  }
}
