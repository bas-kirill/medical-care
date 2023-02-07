package ru.tfs.spring.data.dto;

import lombok.Data;
import ru.tfs.spring.data.entity.type.DocType;

import java.io.Serializable;

@Data
public class IdentityDocumentDto implements Serializable {
    private final DocType type;
    private final String number;
}
