package org.vuchete.person.service.respository;


import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import org.vuchete.person.service.generated.tables.Person;
import org.vuchete.person.service.generated.tables.records.PersonRecord;

/**
 * person-service CRUD operations.
 */
public class PersonServiceRepository {

  private DSLContext jooq;

  /**
   * Вставка записи о гражданине.
   *
   * @param personRecord запись.
   */
  public void insert(PersonRecord personRecord) {
    jooq.transaction(
        () -> jooq
            .insertInto(Person.PERSON)
            .set(personRecord)
            .returningResult()
            .execute()
    );
  }
}