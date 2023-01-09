package org.vuchete.person.service.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressDto {
  @JsonProperty("address")
  private String address;

  @JsonCreator
  public AddressDto(@JsonProperty("accommodation") String address) {
    this.address = address;
  }
}
