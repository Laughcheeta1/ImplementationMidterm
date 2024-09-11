package com.implementacioneintegracion.Parcial.Media.Entity.MediaInPortfolio;

import com.implementacioneintegracion.Parcial.Media.Entity.Media;
import com.implementacioneintegracion.Parcial.Person.Entity.Person;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "Media_In_Portfolio")
@Data
public class MediaInPortfolio {
    @Id
    private MediaInPortfolioCompositeKey id;

    @Column(name = "date_of_media")
    @Temporal(TemporalType.DATE)
    private Date dateOfMedia;

    @Column(name = "description")
    private String description;
}
