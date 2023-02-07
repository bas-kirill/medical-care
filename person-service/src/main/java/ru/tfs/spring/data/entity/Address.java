package ru.tfs.spring.data.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "region_id")
    private Region region;

    private String city;

    private String street;

    @ManyToMany(mappedBy = "residentialAddresses", cascade = {CascadeType.PERSIST})
    private Set<Person> persons = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Address address = (Address) o;
        if (id == null) {
            return Objects.equals(region, address.region) && Objects.equals(city, address.city) && Objects.equals(street, address.street);
        }
        return Objects.equals(id, address.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
