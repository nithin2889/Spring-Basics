package io.playground.xml;

public class CricketCoach implements Coach {

  private FortuneService fortuneService;
  private String email;
  private String team;

  public CricketCoach() {}

  public void setFortuneService(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTeam() {
    return team;
  }

  public void setTeam(String team) {
    this.team = team;
  }

  @Override
  public void intro() {
    System.out.println("Cricket coach says: " + fortune());
  }

  @Override
  public String fortune() {
    return "Indian Cricket Team is the best in the world!" + fortuneService.getFortune();
  }
}
