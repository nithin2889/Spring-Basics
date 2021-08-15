package io.playground.jackson.databinding;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

  private int id;
  private String firstName;
  private String lastName;
  private boolean active;
  private Address address;
  private String[] languages;
}
