package com.implementacioneintegracion.Parcial.Category.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

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
}
