package io.playground.annotations;

import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

  Random myRandom = new Random();
  private String[] data = {
    "Beware of the Wolf in Sheep's clothing",
    "Diligence is the mother of good luck",
    "The journey is the reward"
  };

  @Override
  public String getFortune() {
    int index = myRandom.nextInt(data.length);
    String theFortune = data[index];
    return theFortune;
  }
}
