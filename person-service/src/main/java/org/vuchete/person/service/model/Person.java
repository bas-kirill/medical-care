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

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "second_name")
  private String secondName;

  @Column(name = "address")
  private String address;

  public Person() {
  }

  public Person(String firstName, String secondName, String address) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.address = address;
  }

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getSecondName() {
    return secondName;
  }

  public String getAddress() {
    return address;
  }
}
