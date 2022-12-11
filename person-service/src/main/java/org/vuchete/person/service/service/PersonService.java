package org.vuchete.person.service.service;

import org.springframework.stereotype.Service;
import org.vuchete.person.service.dto.PersonDto;
import org.vuchete.person.service.exceptions.PersonNotFoundException;
import org.vuchete.person.service.model.Person;
import org.vuchete.person.service.respository.PersonRepository;

@Service
public class PersonService {
  private PersonRepository personRepository;

  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public void create(PersonDto personDto) {
    var person = new Person(personDto.fullName, personDto.address, personDto.passport);
    personRepository.save(person);
  }

  public PersonDto getById(Long id) {
    var person = personRepository.findById(id)
        .orElseThrow(PersonNotFoundException::new);
    return new PersonDto(
        person.getFullName(),
        person.getAddress(),
        person.getPassport()
      );
  }

  public boolean verify(String fullName, String passport) {
    var person = personRepository
        .findByFullNameEqualsAndAddressEquals(fullName, passport);
    return person.isPresent();
  }
}
