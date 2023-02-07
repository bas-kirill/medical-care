package ru.tfs.spring.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tfs.spring.data.entity.Region;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, Long> {
    Optional<Region> findByNameEqualsIgnoreCase(String name);
}
