package com.implementacioneintegracion.Parcial.Portfolio.Entity;

import com.implementacioneintegracion.Parcial.Person.Entity.Person;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "Participant_Portfolio")
@Data
public class ParticipantPortfolio {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participant_id", referencedColumnName = "id")
    private Person person;

    @Column(name = "biography")
    private String biography;

    @Column(name = "about")
    private String about;

    @Column(name = "web_page")
    @Size(min = 0, max = 100)
    private String webPage;
}
