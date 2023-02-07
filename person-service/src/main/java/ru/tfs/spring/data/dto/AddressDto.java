package ru.tfs.spring.data.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class AddressDto implements Serializable {

    @NotEmpty
    private final String regionName;

    @NotEmpty
    private final String city;

    @NotEmpty
    private final String street;
}
