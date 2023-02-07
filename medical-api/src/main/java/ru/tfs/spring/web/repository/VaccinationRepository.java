package ru.tfs.spring.web.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.tfs.spring.web.model.entity.Vaccination;

import java.util.Optional;

public interface VaccinationRepository extends JpaRepository<Vaccination, Long> {

    @EntityGraph(attributePaths = {"vaccinationPoint", "vaccine"}, type = EntityGraph.EntityGraphType.LOAD)
    Optional<Vaccination> findFirstByPassportNumber(String passportNumber);

    Optional<Vaccination> findFirstByIsSent(boolean isSent);

}
