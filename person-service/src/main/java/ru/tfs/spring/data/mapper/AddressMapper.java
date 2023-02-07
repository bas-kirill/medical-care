package ru.tfs.spring.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.tfs.spring.data.dto.AddressDto;
import ru.tfs.spring.data.entity.Address;

@Mapper
public interface AddressMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "persons", ignore = true)
    @Mapping(target = "region.name", source = "regionName")
    Address toEntity(AddressDto addressDto);

    @Mapping(target = "regionName", source = "region.name")
    AddressDto toDto(Address address);
}
