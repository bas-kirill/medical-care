package ru.tfs.qrcodestorageservice.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class QRCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hash;

    private String passport;

    private LocalDate expiredDate;

    public QRCode(String hash, String passport, LocalDate expiredDate) {
        this.hash = hash;
        this.passport = passport;
        this.expiredDate = expiredDate;
    }
}
