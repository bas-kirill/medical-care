package ru.tfs.spring.web.mapper;

import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import ru.tfs.spring.web.model.csv.VaccinationCsv;
import ru.tfs.spring.web.model.dto.VaccinationDto;
import ru.tfs.spring.web.model.dto.VaccinationPointDto;
import ru.tfs.spring.web.model.dto.VaccineDto;
import ru.tfs.spring.web.model.entity.Vaccination;
import ru.tfs.spring.web.model.entity.VaccinationPoint;
import ru.tfs.spring.web.model.entity.Vaccine;
import ru.tfs.spring.web.repository.VaccinationPointRepository;
import ru.tfs.spring.web.repository.VaccineRepository;

@Mapper
public abstract class VaccinationMapper {

    @Autowired
    protected VaccinationPointRepository vaccinationPointRepository;
    @Autowired
    protected VaccineRepository vaccineRepository;

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "vaccinationPoint", ignore = true)
    @Mapping(target = "vaccine", ignore = true)
    @Mapping(target = "sent", ignore = true)
    public abstract Vaccination toEntity(VaccinationCsv vaccinationCsv);

    @AfterMapping
    protected void updateEntity(VaccinationCsv vaccinationCsv, @MappingTarget Vaccination vaccination) {
        VaccinationPoint vaccinationPoint = vaccinationPointRepository.findById(vaccinationCsv.getVaccinationPointId())
                .orElse(new VaccinationPoint(
                        vaccinationCsv.getVaccinationPointName(),
                        vaccinationCsv.getVaccinationPointCity(),
                        vaccinationCsv.getVaccinationPointAddress()
                ));
        vaccination.setVaccinationPoint(vaccinationPoint);

        Vaccine vaccine = vaccineRepository.findById(vaccinationCsv.getVaccineId())
                .orElse(new Vaccine(vaccinationCsv.getVaccineName()));
        vaccination.setVaccine(vaccine);
    }

    public abstract VaccinationDto toDto(Vaccination vaccination);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "vaccinations", ignore = true)
    abstract VaccinationPoint vaccinationPointDtoToVaccinationPoint(VaccinationPointDto vaccinationPointDto);

    abstract VaccinationPointDto vaccinationPointToVaccinationPointDto(VaccinationPoint vaccinationPoint);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "vaccinations", ignore = true)
    abstract Vaccine vaccineDtoToVaccine(VaccineDto vaccineDto);

    abstract VaccineDto vaccineToVaccineDto(Vaccine vaccine);
}
