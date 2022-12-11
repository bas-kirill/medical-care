package org.vuchete.medical.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.vuchete.medical.service.dto.VaccinationDto;
import org.vuchete.medical.service.service.MedicalService;

@RestController
@RequestMapping("/api/v1/")
public class MedicalController {

  private MedicalService medicalService;

  public MedicalController(MedicalService medicalService) {
    this.medicalService = medicalService;
  }

  @PostMapping("/process-file")
  public void create(@RequestParam("file") MultipartFile file) {
    medicalService.processFile(file);
  }

  @GetMapping("/vaccination")
  public VaccinationDto getVaccination(@RequestParam("document") String document) {
    return medicalService.getVaccination(document);
  }
}
