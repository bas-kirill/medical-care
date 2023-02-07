package ru.tfs.apigateway.model.medical;

import lombok.Data;

import java.io.Serializable;

@Data
public class VaccinationPointDto implements Serializable {
    private String name;
    private String city;
    private String address;
}
