package ru.tfs.apigateway.model.medical;

import lombok.Data;

import java.io.Serializable;

@Data
public class VaccineDto implements Serializable {
    private String name;
}
