package org.vuchete.person.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.NoSuchElementException;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.vuchete.person.service.model.Person;
import org.vuchete.person.service.repository.PersonRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class PersonRepositoryTest {

  @Autowired
  private PersonRepository personRepository;

  private Person person1;

  @BeforeEach
  void setUp() {
    person1 = new Person("Some Name", "1122-123123");
    Person person2 = new Person("Another Name", "2211-321321");
    personRepository.saveAll(List.of(person1, person2));
  }

  @AfterEach
  void tearDown() {
    personRepository.deleteAll();
  }

  @Test
  @DisplayName("Can not find person by non existing ID")
  void givenPeople_whenGetById_thenReturnNoSuchElementException() {
    assertThrows(NoSuchElementException.class,
        () -> personRepository.findById(100500L).orElseThrow());
  }

  @Test
  @DisplayName("Found only 1 person by full name")
  void givenPeople_whenFindByFullName_thenReturnOnePersonWithNeededFullName() {
    var savedPerson = personRepository.findByFullNameEquals(person1.getFullName()).orElseThrow();
    assertEquals(person1, savedPerson);
  }

  @Test
  @DisplayName("Found several peoples with same full name")
  void givenPeopleWithSameFullName_whenFindByFullName_thenReturnPeopleWithSameFullName() {
    var person3 = new Person(person1.getFullName(), "5555-123123");
    personRepository.save(person3);
    var people = personRepository.findPeopleByFullNameEquals("Some Name");
    assertEquals(List.of(person1, person3), people);
  }

  @Test
  @DisplayName("No people with specific full name")
  void givenPeople_whenFindByNonExistingFullName_thenReturnNobody() {
    var people = personRepository.findPeopleByFullNameEquals("Lord Voldemort");
    assertEquals(people, List.of());
  }
}
