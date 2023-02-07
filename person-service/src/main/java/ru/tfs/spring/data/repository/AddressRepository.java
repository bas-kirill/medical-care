package ru.tfs.spring.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.tfs.spring.data.entity.Address;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query("select a from Address a " +
            "where a.street = :#{#address.street} " +
            "and a.city = :#{#address.city} " +
            "and a.region.name = :#{#address.region.name}")
    Optional<Address> findByAddress(Address address);
}
