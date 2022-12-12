package org.vuchete.person.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact {

  @Id
  @SequenceGenerator(
      name = "contact_id_sequence",
      sequenceName = "person_id_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "contact_id_sequence"
  )
  @Column(name = "id")
  private Long id;

  @Column(name = "phone")
  private String phone;

  @Column(name = "email")
  private String email;

  public Contact() {
  }

  public Contact(Long id, String phone, String email) {
    this.id = id;
    this.phone = phone;
    this.email = email;
  }
}
