package ru.tfs.spring.data.entity;

import lombok.Getter;
import lombok.Setter;
import ru.tfs.spring.data.entity.type.ContactType;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;

    @Enumerated(EnumType.STRING)
    private ContactType contactType;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
