package org.vuchete.person.service.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vuchete.person.service.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}