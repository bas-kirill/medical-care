package org.vuchete.medical.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "vaccination")
public class Vaccination {
  @Id
  @SequenceGenerator(
      name = "vaccination_id_sequence",
      sequenceName = "vaccination_id_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "vaccination_id_sequence"
  )
  private Long id;

  @Column
  private String fullName;

  @Column
  private String passport;

  @Column
  private String vaccineName;

  public Vaccination() {}

  public Vaccination(String fullName, String passport, String vaccineName) {
    this.fullName = fullName;
    this.passport = passport;
    this.vaccineName = vaccineName;
  }

  public Long getId() {
    return id;
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
