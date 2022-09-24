package org.vuchete.person.service.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vuchete.person.service.model.dto.PersonRequest;

/**
 * TODO: use OpenAPI for generation => use delegates.
 */
@RestController
public class PersonServiceController {

  /**
   * Создание / редактирование данные о гражданине.
   *
   * @param person Информация о пользователе.
   */
  @RequestMapping(
      value = "/v1/person",
      method = {RequestMethod.POST, RequestMethod.PUT},
      consumes = MediaType.APPLICATION_JSON_VALUE
  )
  public void v1CreatePersonPost(@RequestBody PersonRequest person) {
    // TODO document why this method is empty
  }

  /**
   * Получить данные о пользователе.
   *
   * @param id Идентификатор пользователя.
   */
  @GetMapping(
      value = "/v1/person/{id}",
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public void v1GetPersonByIdGet(@PathVariable Long id) {
    // TODO document why this method is empty
  }

  /**
   * Получить данные о пользователях постранично в формате: id, ФИО, дата рождения, телефон, данные
   * о основном документе, адрес регистрации.
   *
   * <p>Помимо пагинации реализовано возможность фильтрации по региону.
   *
   * @param region имя региона для фильтрации.
   */
  @GetMapping(
      value = "/v1/person",
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public void v1GetPersonsGet(@RequestParam String region) {
    // TODO document why this method is empty
  }

  /**
   * Проверить валидность связки (ФИО, паспорт).
   *
   * @param fullName Фамилия, имя, отчество.
   * @param passport паспорт.
   */
  @GetMapping(
      value = "/v1/person/verify",
      produces = MediaType.APPLICATION_JSON_VALUE
  )
  public void v1VerifyFullNameAndPassportGet(
      @RequestParam String fullName,
      @RequestParam String passport
  ) {
    // TODO document why this method is empty
  }
}