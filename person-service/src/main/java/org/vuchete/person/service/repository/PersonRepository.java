package org.vuchete.person.service.repository;

import java.util.List;
import java.util.Optional;
import org.aspectj.weaver.patterns.PerObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.vuchete.person.service.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
  Optional<Person> findByFullNameEquals(String name);
//  Optional<Person> findPersonByFullNameEquals
  List<Person> findPeopleByFullNameEquals(String name);
}