package ru.tfs.spring.web.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Vaccine(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "vaccine", orphanRemoval = true)
    private Set<Vaccination> vaccinations = new LinkedHashSet<>();

}
