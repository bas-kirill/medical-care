package org.vuchete.person.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "identity_document")
public class IdentityDocument {

  @Id
  @SequenceGenerator(
      name = "identity_document_id_sequence",
      sequenceName = "identity_document_id_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "identity_document_id_sequence"
  )
  @Column(name = "id")
  private Long id;

  @Enumerated(EnumType.STRING)
  private IdentityDocumentType type;

  private String number;

  @ManyToOne
  @JoinColumn(name = "person_id")
  private Person person;
}
