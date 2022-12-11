package org.vuchete.medical.service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.vuchete.medical.service.dto.VaccinationCsvDto;
import org.vuchete.medical.service.dto.VaccinationDto;
import org.vuchete.medical.service.exceptions.VaccinationNotFoundException;
import org.vuchete.medical.service.repository.VaccinationRepository;
import org.vuchete.medical.service.clients.PersonClient;
import org.vuchete.medical.service.model.Vaccination;
import org.vuchete.medical.service.parsers.VaccinationParser;

@Service
public class MedicalService {
  private static Logger log = LoggerFactory.getLogger(MedicalService.class);

  private final VaccinationParser vaccinationParser;
  private final VaccinationRepository vaccinationRepository;
  private final PersonClient personClient;

  public MedicalService(
      VaccinationParser vaccinationParser,
      VaccinationRepository vaccinationRepository,
      PersonClient personClient) {
    this.vaccinationParser = vaccinationParser;
    this.vaccinationRepository = vaccinationRepository;
    this.personClient = personClient;
  }

  public void processFile(MultipartFile file) {
    var vaccinationCsvs = vaccinationParser.parse(file);
    for (VaccinationCsvDto vaccinationDto : vaccinationCsvs) {
      String fullName = vaccinationDto.getFullName();
      String passport = vaccinationDto.getPassportNumber();
      String vaccineName = vaccinationDto.getVaccineName();

      if (personClient.verify(fullName, passport)) {
        log.warn("Person {} with passport {} didn't verified", fullName, passport);
        continue;
      }

      Vaccination vaccination = new Vaccination(
          fullName,
          passport,
          vaccineName
      );

      try {
        vaccinationRepository.save(vaccination);
      } catch (Exception e) {
        log.error("Error saving file: {}", e.getMessage());
      }
    }
  }

  public VaccinationDto getVaccination(String document) {
    var vaccination = vaccinationRepository
        .findVaccinationByPassportEquals(document)
        .orElseThrow(VaccinationNotFoundException::new);

    return new VaccinationDto(
        vaccination.getFullName(),
        vaccination.getPassport(),
        vaccination.getVaccineName()
    );
  }
}
