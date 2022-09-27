package org.vuchete.person.service.model.records;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * DTO for person documents.
 */
@Entity
@Table(name = "document")
public class Document {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long id;

  @Column
  @Enumerated(EnumType.STRING)
  public Type documentType;

  @ManyToOne
  @JoinColumn(name = "person_id")
  @JsonIgnore
  public Person person;

  enum Type {
    PASSPORT,
    FOREIGN_PASSPORT,
    SNILS,
    INSURANCE_POLICY,
  }
}