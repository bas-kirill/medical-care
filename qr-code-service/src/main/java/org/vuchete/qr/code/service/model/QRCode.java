package org.vuchete.qr.code.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "qr_code")
public class QRCode {
  @Id
  @SequenceGenerator(
      name = "qr_code_id_sequence",
      sequenceName = "qr_code_id_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "qr_code_id_sequence"
  )
  @Column(name = "id")
  private Long id;


}
