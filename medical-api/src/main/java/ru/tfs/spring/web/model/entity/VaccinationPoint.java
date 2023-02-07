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
public class VaccinationPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private String address;

    @OneToMany(mappedBy = "vaccinationPoint", orphanRemoval = true)
    private Set<Vaccination> vaccinations = new LinkedHashSet<>();

    public VaccinationPoint(String name, String city, String address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }
}
