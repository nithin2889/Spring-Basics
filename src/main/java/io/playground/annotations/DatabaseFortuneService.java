package io.playground.annotations;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements FortuneService {

  @Override
  public String getFortune() {
    return "This is a database fortune service";
  }
}
