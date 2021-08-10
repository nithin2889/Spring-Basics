package io.playground.annotations;

import org.springframework.stereotype.Component;

@Component("restFortuneService")
public class RESTFortuneService implements FortuneService {

  @Override
  public String getFortune() {
    return "This is a REST fortune service";
  }
}
