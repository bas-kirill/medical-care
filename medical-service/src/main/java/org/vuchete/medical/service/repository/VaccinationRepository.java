package org.vuchete.medical.service.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.vuchete.medical.service.model.Vaccination;

public interface VaccinationRepository extends CrudRepository<Vaccination, Long> {
  Optional<Vaccination> findVaccinationByPassportEquals(String passport);
}
