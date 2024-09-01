package com.implementacioneintegracion.Parcial.Person.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "Person")
@Data
public class Person {
    @Id
    @Column(name = "id")
    @Size(min = 1, max = 10)
    private String id;
    @Column(name = "name")
    @Size(min = 1, max = 30)
    private String name;
    @Column(name = "cellphone")
    @Size(min = 1, max = 10)
    private String cellphone;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role", referencedColumnName = "id")
    private Role role;
}
