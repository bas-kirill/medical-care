package ru.tfs.apigateway.model.person;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class PersonDto {

    @NotBlank
    @Size(min = 2, max = 60)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 60)
    private String lastName;

    private String middleName;

    @Valid
    private AddressDto registrationAddress;

    private List<IdentityDocumentDto> identityDocuments;

    private List<ContactDto> contacts;

    private List<AddressDto> residentialAddresses;
}
