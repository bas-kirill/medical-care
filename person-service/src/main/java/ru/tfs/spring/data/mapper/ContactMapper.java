package ru.tfs.spring.data.mapper;

import org.mapstruct.*;
import ru.tfs.spring.data.dto.ContactDto;
import ru.tfs.spring.data.entity.Contact;

@Mapper
public interface ContactMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "person", ignore = true)
    Contact toEntity(ContactDto contactDto);

    ContactDto toDto(Contact contact);
}
