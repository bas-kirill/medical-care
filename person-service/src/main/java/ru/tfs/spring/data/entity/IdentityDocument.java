package ru.tfs.spring.data.entity;

import lombok.Getter;
import lombok.Setter;
import ru.tfs.spring.data.entity.type.DocType;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class IdentityDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DocType type;

    private String number;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

}
