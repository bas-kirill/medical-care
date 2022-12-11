package org.vuchete.medical.service.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VaccinationDto {
  @JsonProperty("full_name")
  private String fullName;

  @JsonProperty("passport")
  private String passport;

  @JsonProperty("vaccine_name")
  private String vaccineName;

  @JsonCreator
  public VaccinationDto(
      @JsonProperty("full_name") String fullName,
      @JsonProperty("passport") String passport,
      @JsonProperty("vaccine_name") String vaccineName
  ) {
    this.fullName = fullName;
    this.passport = passport;
    this.vaccineName = vaccineName;
  }

  public String getFullName() {
    return fullName;
  }

  public String getPassport() {
    return passport;
  }

  public String getVaccineName() {
    return vaccineName;
  }
}
