package com.implementacioneintegracion.Parcial.Media.Entity;

import com.implementacioneintegracion.Parcial.Person.Entity.Person;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "Media_In_Portfolio")
@Data
public class MediaInPortfolio {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participant_id", referencedColumnName = "id")
    private Person person;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "media_id", referencedColumnName = "id")
    private Media media;

    @Column(name = "date_of_media")
    @Temporal(TemporalType.DATE)
    private Date dateOfMedia;

    @Column(name = "description")
    private String description;
}
