package org.vuchete.person.service;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.vuchete.person.service.controllers.PersonController;
import org.vuchete.person.service.model.Person;
import org.vuchete.person.service.respository.PersonRepository;
import org.vuchete.person.service.service.PersonService;

@WebMvcTest(PersonController.class)
public class PersonTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  private PersonService personService;

  @Test
  @DisplayName("Person created successfully \uD83D\uDE0A")
  void givenPerson_whenPostPerson_thenReturnNewPerson() throws Exception {
    Person person = new Person("Alex", "1122-123123");

    when(personService.create(person))
        .thenReturn(person);

    mvc.perform(post("/api/v1/person-service/")
            .content(new ObjectMapper().writeValueAsString(person))
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.name", is("Alex")))
        .andExpect(jsonPath("$.passport", is("1122-123123")));

    verify(personService, times(1)).create(person);
  }
}
