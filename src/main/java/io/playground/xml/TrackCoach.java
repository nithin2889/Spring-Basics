package io.playground.xml;

public class TrackCoach implements Coach {

  private FortuneService fortuneService;

  public TrackCoach() {}

  public TrackCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  @Override
  public void intro() {
    System.out.println("Track coach says: " + fortune());
  }

  @Override
  public String fortune() {
    return "Just do it: " + fortuneService.getFortune();
  }

  // add an init method
  public void doMyInitStuff() {
    System.out.println("TrackCoach = inside method doMyInitStuff");
  }

  // add a destroy method
  public void doMyDestroyStuff() {
    System.out.println("TrackCoach = inside method doMyDestroyStuff");
  }
}
