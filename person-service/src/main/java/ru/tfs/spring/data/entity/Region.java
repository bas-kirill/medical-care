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
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "region", orphanRemoval = true)
    private Set<Address> addresses = new LinkedHashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
            return false;
        }
        Region region = (Region) o;
        if (id == null) {
            return Objects.equals(name, region.name);
        }
        return Objects.equals(id, region.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
