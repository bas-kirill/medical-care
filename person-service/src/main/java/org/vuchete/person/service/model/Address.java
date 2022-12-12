package org.vuchete.person.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
  @Id
  @SequenceGenerator(
      name = "address_id_sequence",
      sequenceName = "person_id_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "address_id_sequence"
  )
  @Column(name = "id")
  private Long id;

  @Column(name = "accomodation")
  private String accomodation;

  @Column(name = "registration_address")
  private String registrationAddress;

  public Address() {}

  public Address(Long id, String accommodation, String registrationAddress) {
    this.id = id;
    this.accomodation = accommodation;
    this.registrationAddress = registrationAddress;
  }
}
