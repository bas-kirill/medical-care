package org.vuchete.person.service.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

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
  private Long id;

  @Column(name = "full_name")
  private String fullName;

  @Column(name = "passport")
  private String passport;

//  @ManyToOne(cascade = CascadeType.ALL)
//  @JoinColumn(name = "registration_address_id")
//  private Address registrationAddress;
//
//  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//  @JoinTable(
//      name = "person_accommodations",
//      joinColumns = @JoinColumn(name = "person_id"),
//      inverseJoinColumns = @JoinColumn(name = "accommodation_id")
//  )
//  private Set<Address> accommodations = new LinkedHashSet<>();
//
//  @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
//  private Set<IdentityDocument> documents = new LinkedHashSet<>();

  // Avoid "No default constructor for entity"
  public Person() {
  }

  public Person(String fullName, String passport) {
    this.fullName = fullName;
    this.passport = passport;
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

//  public Address getRegistrationAddress() {
//    return registrationAddress;
//  }
//
//  public Set<Address> getAccommodations() {
//    return accommodations;
//  }
//
//  public Set<IdentityDocument> getDocuments() {
//    return documents;
//  }
}
