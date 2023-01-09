package org.vuchete.person.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.vuchete.person.service.dto.PersonDto;
import org.vuchete.person.service.model.Person;
import org.vuchete.person.service.service.PersonService;

@RestController
@RequestMapping(path = "/api/v1/person-service", produces = "application/json")
public class PersonController {

  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  Person createPerson(@RequestBody Person person) {
    return personService.create(person);
  }

  @GetMapping
  Iterable<Person> getPeople() {
    return personService.findAll();
  }

  @GetMapping("/{id}")
  Person getPersonById(@PathVariable Long id) {
    return personService.getById(id);
  }

  @GetMapping("/verification")
  boolean verifyPerson(
      @RequestParam("full_name") String fullName,
      @RequestParam("passport") String passport
  ) {
    return personService.verify(fullName, passport);
  }

  @PatchMapping("/{id}}")
  Person updatePerson(@PathVariable String id, @RequestBody Person person) {
    return null;
  }

  @DeleteMapping("/{id}")
  void deletePerson(@PathVariable String id) {
    // TODO
  }
}
