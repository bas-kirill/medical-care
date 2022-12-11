package org.vuchete.person.service.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonDto {

  @JsonProperty("first_name")
  public String firstName;

  @JsonProperty("second_name")
  public String secondName;

  @JsonProperty("address")
  public String address;

  @JsonCreator
  public PersonDto(
      @JsonProperty("first_name") String firstName,
      @JsonProperty("second_name") String secondName,
      @JsonProperty("address") String address
  ) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.address = address;
  }
}
