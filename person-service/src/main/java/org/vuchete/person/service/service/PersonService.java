package org.vuchete.person.service.service;

import org.springframework.stereotype.Service;
import org.vuchete.person.service.exceptions.PersonNotFoundException;
import org.vuchete.person.service.model.Person;
import org.vuchete.person.service.repository.PersonRepository;

@Service
public class PersonService {

  private final PersonRepository personRepository;

  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public Person create(Person person) {
    return personRepository.save(person);
  }

  public Iterable<Person> findAll() {
    return personRepository.findAll();
  }

  public Person getById(Long id) {
    return personRepository.findById(id)
        .orElseThrow(PersonNotFoundException::new);
  }

  public boolean verify(String fullName, String passport) {
    var person = personRepository
        .findByFullNameEquals(fullName);
    return person.isPresent();
  }
}
