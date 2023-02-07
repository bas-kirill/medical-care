package ru.tfs.spring.data.controller;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ru.tfs.spring.data.dto.PersonDto;
import ru.tfs.spring.data.service.PersonService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public PersonDto create(@Valid @RequestBody PersonDto personDto) {
        return personService.create(personDto);
    }

    @PutMapping("/{id}")
    public PersonDto update(@PathVariable long id, @Valid @RequestBody PersonDto personDto) {
        return personService.update(id, personDto);
    }

    @GetMapping("/{id}")
    public PersonDto getById(@PathVariable long id) {
        return personService.getById(id);
    }

    @GetMapping
    public Page<PersonDto> getAll(@RequestParam(required = false) String region, @ParameterObject Pageable pageable) {
        return personService.getAll(region, pageable);
    }

    @GetMapping("/passport/{passport}")
    public PersonDto getByPassport(@PathVariable String passport) {
        return personService.getByPassport(passport);
    }

    @GetMapping("/verify")
    public boolean verify(
            @RequestParam @NonNull String name,
            @RequestParam @NonNull String passport
    ) {
        return personService.verify(name, passport);
    }
}
