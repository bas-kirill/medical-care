package ru.tfs.spring.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.tfs.spring.data.dto.IdentityDocumentDto;
import ru.tfs.spring.data.entity.IdentityDocument;

@Mapper
public interface DocumentMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "person", ignore = true)
    IdentityDocument toEntity(IdentityDocumentDto identityDocumentDto);

    IdentityDocumentDto toDto(IdentityDocument identityDocument);
}
