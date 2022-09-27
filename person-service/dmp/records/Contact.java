package org.vuchete.person.service.model.records;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Person contacts.
 */
@Entity
@Table(name = "contact")
public class Contact {

  @Id
  @GeneratedValue
  public Long id;

  @Column
  public String phone;

  @Column
  public String email;

  @ManyToOne
  @JoinColumn(name = "person_id")
  @JsonIgnore
  public Person person;
}