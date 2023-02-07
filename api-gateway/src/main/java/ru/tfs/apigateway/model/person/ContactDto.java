package ru.tfs.apigateway.model.person;

import lombok.Data;

import java.io.Serializable;

@Data
public class ContactDto implements Serializable {
    private String value;
    private ContactType contactType;
}
