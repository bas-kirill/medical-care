package ru.tfs.apigateway.model.person;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class AddressDto implements Serializable {

    @NotEmpty
    private String regionName;

    @NotEmpty
    private String city;

    @NotEmpty
    private String street;
}
