package org.vuchete.person.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.google.common.net.HttpHeaders;
import org.vuchete.person.service.controllers.PersonController;

@WebMvcTest(PersonController.class)
class PersonControllerTest {
  @Autowired
  private PersonController personController;

  @Autowired
  private MockMvc mvc;

  @Test
  @DisplayName("")
  void shouldCreatePerson() throws Exception {
    String personJson = "\"full_name\": \"Alex\", \"passport\":\"1122-123123\"";
    mvc.perform(post("/api/v1/person-service")
            .content(personJson)
            .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void shouldDeletePerson() throws Exception {

  }
}
