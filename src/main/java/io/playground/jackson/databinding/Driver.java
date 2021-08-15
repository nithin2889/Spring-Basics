package io.playground.jackson.databinding;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class Driver {

  public static void main(String[] args) {
    try {
      // create the object mapper
      ObjectMapper mapper = new ObjectMapper();
      // read JSON file and map/convert to Java POJO
      Student theStudent =
          mapper.readValue(new File("src/main/resources/sample-full.json"), Student.class);
      System.out.println(
          "Student is: " + theStudent.getFirstName() + " " + theStudent.getLastName());
      System.out.println("Street: " + theStudent.getAddress().getStreet());
      System.out.println("City: " + theStudent.getAddress().getCity());
      System.out.println("Languages: ");
      for (String language : theStudent.getLanguages()) {
        System.out.println(language);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
