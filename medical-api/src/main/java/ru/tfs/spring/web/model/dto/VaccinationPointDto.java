package ru.tfs.spring.web.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class VaccinationPointDto implements Serializable {
    private final String name;
    private final String city;
    private final String address;
}
