package ru.tfs.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.tfs.spring.web.model.dto.VaccinationDto;
import ru.tfs.spring.web.service.VaccinationService;

@RestController
@RequiredArgsConstructor
public class VaccinationController {

    private final VaccinationService vaccinationService;

    @PostMapping("/process-file")
    public void create(@RequestParam("file") MultipartFile file) {
        vaccinationService.processFile(file);
    }

    @GetMapping("/vaccination")
    public VaccinationDto getVaccination(@RequestParam("document") String document) {
        return vaccinationService.getVaccination(document);
    }
}
