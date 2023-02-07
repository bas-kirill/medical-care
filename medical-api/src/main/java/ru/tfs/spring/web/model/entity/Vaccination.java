package ru.tfs.spring.web.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Vaccination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate vaccinationDate;

    private String fullName;

    private String passportNumber;

    private boolean isSent;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "vaccination_point_id")
    private VaccinationPoint vaccinationPoint;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "vaccine_id")
    private Vaccine vaccine;

}
