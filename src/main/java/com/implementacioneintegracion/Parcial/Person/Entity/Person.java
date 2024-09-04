package com.implementacioneintegracion.Parcial.Person.Entity;

import com.implementacioneintegracion.Parcial.Event.Entity.MiddleTables.AttendeeEvent.AttendeeEvent;
import com.implementacioneintegracion.Parcial.Event.Entity.MiddleTables.OrganizerEvent.OrganizerEvent;
import com.implementacioneintegracion.Parcial.Event.Entity.MiddleTables.ParticipantEvent.ParticipantEvent;
import com.implementacioneintegracion.Parcial.Portfolio.Entity.ParticipantPortfolio;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

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

    @OneToOne(mappedBy = "person", fetch = FetchType.LAZY)
    private ParticipantPortfolio participantPortfolio;

    @OneToMany(mappedBy = "id.person", fetch = FetchType.LAZY)
    private List<CategoryParticipant> participantCategories;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private List<OrganizerEvent> organizerEvents;

    @OneToMany(mappedBy = "id.person", fetch = FetchType.LAZY)
    private List<ParticipantEvent> participantEvents;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private List<AttendeeEvent> purchasedTickets;
}
