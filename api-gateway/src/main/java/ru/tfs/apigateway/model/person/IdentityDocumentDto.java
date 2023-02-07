package ru.tfs.apigateway.model.person;

import lombok.Data;

import java.io.Serializable;

@Data
public class IdentityDocumentDto implements Serializable {
    private DocType type;
    private String number;
}
