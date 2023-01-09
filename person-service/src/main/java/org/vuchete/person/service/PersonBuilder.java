package org.vuchete.person.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.vuchete.person.service.model.Person;

@TestConfiguration
public class PersonBuilder {

  @Bean
  Map<String, Person> buildPersonFromCsv() throws IOException {
    Map<String, Person> nameToPerson = new HashMap<>();
    try (BufferedReader reader = new BufferedReader(
        new FileReader("src/main/resources/persons_information.csv")
    )) {
      String line;
      do {
        line = reader.readLine();
        System.out.println("line" + line);
        if (line != null) {
          String[] personsString = line.split(";");
          String name = personsString[0].trim();
          String passport = personsString[1].trim();
          Person person = new Person(name, passport);
          nameToPerson.put(name, person);
        }
      } while (line != null);
    }
    return nameToPerson;
  }
}
