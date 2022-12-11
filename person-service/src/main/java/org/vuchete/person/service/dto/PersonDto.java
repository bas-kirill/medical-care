package org.vuchete.person.service.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonDto {

  @JsonProperty("full_name")
  public String fullName;

  @JsonProperty("address")
  public String address;

  @JsonProperty("passport")
  public String passport;

  @JsonCreator
  public PersonDto(
      @JsonProperty("full_name") String fullName,
      @JsonProperty("address") String address,
      @JsonProperty("passport") String passport
  ) {
    this.fullName = fullName;
    this.address = address;
    this.passport = passport;
  }
}
