package com.implementacioneintegracion.Parcial.Portfolio.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "Media_In_Portfolio")
@Data
public class MediaInPortfolio {
    @Id
    private MediaInPortfolioCompositeKey key;

    @Column(name = "date_of_media")
    @Temporal(TemporalType.DATE)
    private Date dateOfMedia;

    @Column(name = "description")
    private String description;
}
