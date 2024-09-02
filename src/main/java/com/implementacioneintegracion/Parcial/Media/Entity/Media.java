package com.implementacioneintegracion.Parcial.Media.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "Media")
@Data
public class Media {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "url")
    @Size(min = 1, max = 100)
    private String url;
    @Column(name = "media_type")
    private char media_type;
}
