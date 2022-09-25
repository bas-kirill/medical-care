package org.vuchete.person.service.model.records;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * DTO described person.
 */
@Entity
@Table(name = "person")
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  public Integer id;

  @Column
  public String fullName;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "person_id")
  public Set<Document> documents = new HashSet<>();

  @OneToOne(cascade = CascadeType.ALL)
  public Address registrationAddress;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(
      name = "person_address",
      joinColumns = @JoinColumn(name = "person_id"),
      inverseJoinColumns = @JoinColumn(name = "address_id")
  )
  public Set<Address> residenceAddresses = new HashSet<>();

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "person_id")
  public Set<Contact> contacts = new HashSet<>();

  @Column
  public boolean isHidden = false;
}