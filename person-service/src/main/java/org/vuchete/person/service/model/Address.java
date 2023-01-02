package org.vuchete.person.service.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

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

  @Column(name = "address")
  private String address;

  @ManyToMany(mappedBy = "accommodations", cascade = {CascadeType.PERSIST})
  private Set<Person> persons = new LinkedHashSet<>();
}
