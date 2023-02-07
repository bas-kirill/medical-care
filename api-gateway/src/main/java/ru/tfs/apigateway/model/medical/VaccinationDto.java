package ru.tfs.apigateway.model.medical;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VaccinationDto {

    private LocalDate vaccinationDate;
    private String fullName;
    private String passportNumber;
    private VaccinationPointDto vaccinationPoint;
    private VaccineDto vaccine;
}
