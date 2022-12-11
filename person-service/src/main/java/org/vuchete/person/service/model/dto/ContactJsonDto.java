package org.vuchete.person.service.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Jsonizable POJO.
 */
public class ContactJsonDto {
  @JsonProperty("phone")
  public String phone;

  @JsonProperty("email")
  public String email;
}
