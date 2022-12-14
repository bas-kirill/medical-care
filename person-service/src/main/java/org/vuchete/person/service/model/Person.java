package org.vuchete.person.service.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class Person {

  @Id
  @SequenceGenerator(
      name = "person_id_sequence",
      sequenceName = "person_id_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "person_id_sequence"
  )
  @Column(name = "id")
  private Long id;

  @Column(name = "full_name")
  private String fullName;

  @Column(name = "address")
  private String address;

  @Column(name = "passport")
  private String passport;

  public Person() {
  }

  public Person(String fullName, String address, String passport) {
    this.fullName = fullName;
    this.address = address;
    this.passport = passport;
  }

  public Long getId() {
    return id;
  }

  public String getFullName() {
    return fullName;
  }

  public String getAddress() {
    return address;
  }

  public String getPassport() {
    return passport;
  }
}
