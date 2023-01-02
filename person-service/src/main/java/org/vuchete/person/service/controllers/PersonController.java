package org.vuchete.person.service.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vuchete.person.service.dto.PersonDto;
import org.vuchete.person.service.service.PersonService;

@RestController
@RequestMapping("/api/v1/person-service/")
public class PersonController {

  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public void v1CreatePersonPost(@RequestBody PersonDto personDto) {
    personService.create(personDto);
  }

  @GetMapping(value = "/{id}")
  public PersonDto v1GetPersonByIdGet(@PathVariable Long id) {
    return personService.getById(id);
  }

  @GetMapping(value = "/verification")
  public boolean v1VerifyPersonGet(
      @RequestParam("full_name") String fullName,
      @RequestParam("passport") String passport
  ) {
    return personService.verify(fullName, passport);
  }
}
