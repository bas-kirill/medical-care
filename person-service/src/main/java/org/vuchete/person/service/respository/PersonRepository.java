package org.vuchete.person.service.respository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.vuchete.person.service.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
  Optional<Person> findByFullNameEqualsAndAddressEquals(String name, String address);
}