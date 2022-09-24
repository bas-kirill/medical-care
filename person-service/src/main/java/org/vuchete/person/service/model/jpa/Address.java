package org.vuchete.person.service.model.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * DTO for person addresses.
 */
@Entity
@Table(name = "address")
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false)
  private Long id;

  @Column
  public String country;

  @Column
  public String region;

  @Column
  public String city;

  @Column
  public String street;

  @Column
  public String building;


  @ManyToMany
  @JoinTable(name = "person_address", joinColumns = @JoinColumn(name = "address_id"), inverseJoinColumns = @JoinColumn(name = "person_id"))
  @JsonIgnore
  public Set<Person> person = new HashSet<>();

  public Long getId() {
    return id;
  }
}
