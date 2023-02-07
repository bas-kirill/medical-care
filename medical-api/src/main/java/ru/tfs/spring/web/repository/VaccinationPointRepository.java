package ru.tfs.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tfs.spring.web.model.entity.VaccinationPoint;

public interface VaccinationPointRepository extends JpaRepository<VaccinationPoint, Long> {
}
