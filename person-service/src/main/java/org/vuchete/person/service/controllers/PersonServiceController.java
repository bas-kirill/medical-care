package org.vuchete.person.service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.vuchete.person.service.model.dto.PersonJsonDto;
import org.vuchete.person.service.service.PersonServiceService;

/**
 * TODO: use OpenAPI for generation => use delegates.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/person-service/")
public class PersonServiceController {

  private final PersonServiceService personServiceService;

  /**
   * Создание / редактирование данные о гражданине.
   *
   * @param personJson Информация о пользователе.
   */
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public void v1CreatePost(@RequestBody PersonJsonDto personJson) {
    personServiceService.create(personJson);
  }

  /**
   * Получить данные о пользователе.
   *
   * @param id Идентификатор пользователя.
   */
  @GetMapping(value = "/{id}")
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
  @GetMapping
  public void v1GetPersonsGet(@RequestParam String region) {
    // TODO document why this method is empty
  }

  /**
   * Проверить валидность связки (ФИО, паспорт).
   *
   * @param fullName Фамилия, имя, отчество.
   * @param passport паспорт.
   */
  @GetMapping("/verify")
  public void v1VerifyFullNameAndPassportGet(
      @RequestParam String fullName,
      @RequestParam String passport
  ) {
    // TODO document why this method is empty
  }
}