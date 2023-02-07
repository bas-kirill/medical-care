package ru.tfs.spring.data.dto;

import lombok.Data;
import ru.tfs.spring.data.entity.type.ContactType;

import java.io.Serializable;

@Data
public class ContactDto implements Serializable {
    private final String value;
    private final ContactType contactType;
}
