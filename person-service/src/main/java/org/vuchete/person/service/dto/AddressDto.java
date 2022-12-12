package org.vuchete.person.service.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressDto {
  @JsonProperty("accommodation")
  private String accommodation;

  @JsonProperty("registration_address")
  private String registrationAddress;

  @JsonCreator
  public AddressDto(
      @JsonProperty("accommodation") String accommodation,
      @JsonProperty("registration_address") String registrationAddress
  ) {
    this.accommodation = accommodation;
    this.registrationAddress = registrationAddress;
  }
}
