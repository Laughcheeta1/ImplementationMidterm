package com.implementacioneintegracion.Parcial.Category.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.implementacioneintegracion.Parcial.Person.Entity.CategoryParticipant.CategoryParticipant;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Category")
@Data
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "name")
    @Size(min = 3, max = 15)
    private String name;

    @OneToMany(mappedBy = "id.category", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CategoryParticipant> categoryParticipants;
}
