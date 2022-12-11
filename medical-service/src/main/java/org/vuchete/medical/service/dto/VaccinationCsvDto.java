package org.vuchete.medical.service.dto;


public class VaccinationCsvDto {

  private String fullName;
  private String passportNumber;
  private String vaccineName;

  public VaccinationCsvDto(String fullName, String passportNumber, String vaccineName) {
    this.fullName = fullName;
    this.passportNumber = passportNumber;
    this.vaccineName = vaccineName;
  }

  public String getFullName() {
    return fullName;
  }

  public String getPassportNumber() {
    return passportNumber;
  }

  public String getVaccineName() {
    return vaccineName;
  }
}
