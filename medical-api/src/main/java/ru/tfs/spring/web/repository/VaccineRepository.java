package ru.tfs.spring.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tfs.spring.web.model.entity.Vaccine;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
}
