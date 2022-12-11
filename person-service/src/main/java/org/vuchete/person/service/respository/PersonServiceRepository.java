package org.vuchete.person.service.respository;


import org.jooq.DSLContext;
import org.springframework.stereotype.Component;
import org.vuchete.person.service.generated.tables.Person;
import org.vuchete.person.service.generated.tables.records.PersonRecord;

/**
 * person-service CRUD operations.
 */
@Component
public class PersonServiceRepository {

  private final DSLContext jooq;

  public PersonServiceRepository(DSLContext jooq) {
    this.jooq = jooq;
  }

  /**
   * Вставка записи о гражданине.
   *
   * @param personRecord запись.
   */
  public void insert(PersonRecord personRecord) {
    jooq.insertInto(Person.PERSON).set(personRecord).execute();
//    jooq.transaction(
//        () -> jooq
//            .insertInto(Person.PERSON)
//            .set(personRecord)
//            .returningResult()
//            .execute()
//    );
  }
}