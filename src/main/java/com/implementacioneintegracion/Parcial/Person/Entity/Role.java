package com.implementacioneintegracion.Parcial.Person.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Role")
@Data
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(name = "name")
    @Size(min = 1, max = 10)
    private String name;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<Person> persons;
}
