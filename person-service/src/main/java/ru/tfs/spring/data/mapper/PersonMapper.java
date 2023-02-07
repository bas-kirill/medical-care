package ru.tfs.spring.data.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import ru.tfs.spring.data.dto.PersonDto;
import ru.tfs.spring.data.entity.Address;
import ru.tfs.spring.data.entity.Person;
import ru.tfs.spring.data.entity.Region;
import ru.tfs.spring.data.repository.AddressRepository;
import ru.tfs.spring.data.repository.RegionRepository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(uses = {AddressMapper.class, ContactMapper.class, DocumentMapper.class})
public abstract class PersonMapper {

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private AddressRepository addressRepository;

    public abstract PersonDto toDto(Person person);

    @Mapping(target = "id", ignore = true)
    public abstract Person toEntity(PersonDto personDto);

    public Page<PersonDto> toDto(Page<Person> people) {
        return people.map(this::toDto);
    }

    @AfterMapping
    protected void fillEntity(PersonDto personDto, @MappingTarget Person person) {
        person.getIdentityDocuments().forEach(identityDocument -> identityDocument.setPerson(person));
        person.getContacts().forEach(contact -> contact.setPerson(person));
        updateRegistrationAddress(person);
        updateResidentialAddresses(person);
    }

    private void updateRegistrationAddress(Person person) {
        Address registrationAddress = person.getRegistrationAddress();
        Optional<Address> registrationAddressFromDb = addressRepository.findByAddress(registrationAddress);
        if (registrationAddressFromDb.isPresent()) {
            Address address = registrationAddressFromDb.get();
            address.getPersons().add(person);
            person.setRegistrationAddress(address);
        } else {
            updateRegionFromDb(registrationAddress);
        }
    }

    private void updateResidentialAddresses(Person person) {
        Set<Address> residentialAddresses = person.getResidentialAddresses();
        Address registrationAddress = person.getRegistrationAddress();
        Set<Address> newResidentialAddresses = residentialAddresses.stream()
                .map(residentialAddress -> updateResidentialAddressFromDb(person, registrationAddress, residentialAddress))
                .collect(Collectors.toSet());
        person.setResidentialAddresses(newResidentialAddresses);
    }

    private Address updateResidentialAddressFromDb(Person person, Address registrationAddress, Address residentialAddress) {
        if (residentialAddress.equals(registrationAddress)) {
            return registrationAddress;
        }
        Optional<Address> residentialAddressFromDb = addressRepository.findByAddress(residentialAddress);
        if (residentialAddressFromDb.isPresent()) {
            Address address = residentialAddressFromDb.get();
            address.getPersons().add(person);
            return address;
        }
        updateResidentialRegion(registrationAddress, residentialAddress);
        return residentialAddress;
    }

    private void updateResidentialRegion(Address registrationAddress, Address residentialAddress) {
        Region registrationAddressRegion = registrationAddress.getRegion();
        if (residentialAddress.getRegion().equals(registrationAddressRegion)) {
            residentialAddress.setRegion(registrationAddressRegion);
        } else {
            updateRegionFromDb(residentialAddress);
        }
    }

    private void updateRegionFromDb(Address residentialAddress) {
        String regionName = residentialAddress.getRegion().getName();
        getRegionByName(regionName)
                .ifPresent(region -> {
                            residentialAddress.setRegion(region);
                            region.getAddresses().add(residentialAddress);
                        }
                );
    }

    private Optional<Region> getRegionByName(String name) {
        return regionRepository.findByNameEqualsIgnoreCase(name);
    }
}
