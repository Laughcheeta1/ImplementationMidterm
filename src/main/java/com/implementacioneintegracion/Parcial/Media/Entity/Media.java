package com.implementacioneintegracion.Parcial.Media.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.implementacioneintegracion.Parcial.Media.Entity.EventMedia.EventMedia;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

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
    private char mediaType;

    @OneToMany(mappedBy = "id.media", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<EventMedia> mediaEvent;
}
