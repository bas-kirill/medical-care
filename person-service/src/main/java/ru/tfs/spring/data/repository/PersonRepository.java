package ru.tfs.spring.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.tfs.spring.data.entity.Person;
import ru.tfs.spring.data.entity.type.DocType;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select (count(p) > 0) from Person p inner join p.identityDocuments identityDocuments " +
            "where p.firstName = :firstName and identityDocuments.type = :type and identityDocuments.number = :number")
    boolean existsByNameAndDoc(String firstName, String number, DocType type);

    @Query("select distinct p from Person p inner join p.residentialAddresses addresses where :region is null or addresses.region.name = :region")
    Page<Person> findAllByRegion(String region, Pageable pageable);

    @Query("select p from Person p inner join p.identityDocuments identityDocuments " +
            "where identityDocuments.number = :number and identityDocuments.type = :type")
    Person findByIdentityDocument(String number, DocType type);


}
