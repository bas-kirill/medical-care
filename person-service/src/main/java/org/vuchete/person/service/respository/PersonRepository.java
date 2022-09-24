package org.vuchete.person.service.respository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vuchete.person.service.model.jpa.Person;

/**
 * person-service CRUD operations.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}