package io.playground.jackson.databinding;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString
public class Address {

  private String street;
  private String city;
  private String state;
  private String zip;
  private String country;
}
