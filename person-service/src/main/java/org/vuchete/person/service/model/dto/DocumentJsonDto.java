package org.vuchete.person.service.model.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Jsonizable POJO.
 */
public class DocumentJsonDto {

  @JsonProperty("document_type")
  public Type documentType;

  enum Type {
    @JsonProperty("passport")
    PASSPORT,
    @JsonProperty("foreign_passport")
    FOREIGN_PASSPORT,
    @JsonProperty("snils")
    SNILS,
    @JsonProperty("insurance_policy")
    INSURANCE_POLICY,
  }
}
