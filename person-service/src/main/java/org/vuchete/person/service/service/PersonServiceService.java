package org.vuchete.person.service.service;

import org.springframework.stereotype.Service;
import org.vuchete.person.service.generated.tables.records.PersonRecord;
import org.vuchete.person.service.model.dto.PersonJsonDto;
import org.vuchete.person.service.respository.PersonServiceRepository;

@Service
public class PersonServiceService {

  private final PersonServiceRepository personServiceRepository;

  public PersonServiceService(PersonServiceRepository personServiceRepository) {
    this.personServiceRepository = personServiceRepository;
  }

  public void create(PersonJsonDto personJson) {
    personServiceRepository.insert(
        new PersonRecord(
            1,
            personJson.firstName,
            personJson.secondName,
            ""
        )
    );
  }
}