package ru.tfs.spring.data.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.tfs.spring.data.dto.PersonDto;
import ru.tfs.spring.data.entity.Person;
import ru.tfs.spring.data.entity.type.DocType;
import ru.tfs.spring.data.exception.UserNotFoundException;
import ru.tfs.spring.data.mapper.PersonMapper;
import ru.tfs.spring.data.repository.PersonRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonDto create(PersonDto personDto) {
        return save(personDto);
    }

    public PersonDto update(long id, PersonDto personDto) {
        return save(id, personDto);
    }

    public PersonDto getById(long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        return personMapper.toDto(person);
    }

    public Page<PersonDto> getAll(String region, Pageable pageable) {
        Page<Person> people = personRepository.findAllByRegion(region, pageable);
        return personMapper.toDto(people);
    }

    public boolean verify(String name, String passport) {
        log.info("{} {}", name, passport);
        return personRepository.existsByNameAndDoc(name, passport, DocType.PASSPORT);
    }

    private PersonDto save(PersonDto personDto) {
        return save(null, personDto);
    }

    private PersonDto save(Long id, PersonDto personDto) {
        Person person = personMapper.toEntity(personDto);
        person.setId(id);
        Person savedPerson = personRepository.save(person);
        return personMapper.toDto(savedPerson);
    }

    public PersonDto getByPassport(String passport) {
        Person person = personRepository.findByIdentityDocument(passport, DocType.PASSPORT);
        return personMapper.toDto(person);
    }
}
