package io.playground.xml;

public class BasketballCoach implements Coach {

  private FortuneService fortuneService;

  public BasketballCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  @Override
  public void intro() {
    System.out.println("Basketball coach says: " + fortune());
  }

  @Override
  public String fortune() {
    return fortuneService.getFortune();
  }
}
