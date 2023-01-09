package org.vuchete.person.service.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.LinkedHashSet;
import java.util.Set;
import org.vuchete.person.service.model.Address;

public class PersonDto {

  @JsonProperty("full_name")
  public String fullName;

  @JsonProperty("registration_address")
  public Address registrationAddress;

  @JsonProperty("accommodations")
  public Set<Address> accommodations;

  @JsonProperty("passport")
  public String passport;

  @JsonCreator
  public PersonDto(
      @JsonProperty("full_name") String fullName,
      @JsonProperty("registration_address") Address registrationAddress,
      @JsonProperty("accommodations") Set<Address> accommodations,
      @JsonProperty("passport") String passport
  ) {
    this.fullName = fullName;
    this.registrationAddress = registrationAddress;
    this.passport = passport;
  }
}
