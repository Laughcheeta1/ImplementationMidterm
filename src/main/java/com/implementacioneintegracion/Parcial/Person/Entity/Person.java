package com.implementacioneintegracion.Parcial.Person.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.implementacioneintegracion.Parcial.Event.Entity.MiddleTables.AttendeeEvent.AttendeeEvent;
import com.implementacioneintegracion.Parcial.Event.Entity.MiddleTables.OrganizerEvent.OrganizerEvent;
import com.implementacioneintegracion.Parcial.Event.Entity.MiddleTables.ParticipantEvent.ParticipantEvent;
import com.implementacioneintegracion.Parcial.Person.Entity.CategoryParticipant.CategoryParticipant;
import com.implementacioneintegracion.Parcial.Portfolio.Entity.ParticipantPortfolio;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private String name;

    @Column(name = "cellphone")
    @Size(min = 1, max = 10)
    @NotNull
    private String cellphone;

    @Column(name = "user_name")
    @Size(min = 1, max = 12)
    @NotNull
    private String userName;

    @Column(name = "password")
    @Size(min = 1, max = 20)
    @NotNull
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role", referencedColumnName = "id")
    @NotNull
    private Role role;

    @OneToOne(mappedBy = "person", fetch = FetchType.LAZY)
    private ParticipantPortfolio participantPortfolio;

    @OneToMany(mappedBy = "id.person", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CategoryParticipant> participantCategories;

    @OneToMany(mappedBy = "id.person", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<OrganizerEvent> organizerEvents;

    @OneToMany(mappedBy = "id.person", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ParticipantEvent> participantEvents;

    @OneToMany(mappedBy = "id.person", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<AttendeeEvent> purchasedTickets;
}
