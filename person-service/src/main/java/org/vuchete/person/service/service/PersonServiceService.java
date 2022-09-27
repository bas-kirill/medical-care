package org.vuchete.person.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vuchete.person.service.generated.Tables;
import org.vuchete.person.service.generated.tables.records.PersonRecord;
import org.vuchete.person.service.model.dto.PersonJsonDto;
import org.vuchete.person.service.respository.PersonServiceRepository;

/**
 * person-service.
 */
@Service
public class PersonServiceService {

  private PersonServiceRepository personServiceRepository;

  /**
   * Создание записи о гражданине.
   *
   * @param personJson Информация о пользователе.
   */
  public void create(PersonJsonDto personJson) {
    personServiceRepository.insert(
        new PersonRecord(
            1, // id
            personJson.firstName, // firstName
            personJson.secondName, // secondName
            personJson.middleName.orElse(null) // middleName
        )
    );
  }

}