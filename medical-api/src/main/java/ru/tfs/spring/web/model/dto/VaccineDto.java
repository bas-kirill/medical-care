package ru.tfs.spring.web.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class VaccineDto implements Serializable {
    private final String name;
}
