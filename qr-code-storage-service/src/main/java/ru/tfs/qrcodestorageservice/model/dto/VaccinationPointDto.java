package ru.tfs.qrcodestorageservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VaccinationPointDto implements Serializable {
    private String name;
    private String city;
    private String address;
}
