package com.implementacioneintegracion.Parcial.Event.Entity;

import com.implementacioneintegracion.Parcial.Event.Entity.MiddleTables.AttendeeEvent.AttendeeEvent;
import com.implementacioneintegracion.Parcial.Event.Entity.MiddleTables.OrganizerEvent.OrganizerEvent;
import com.implementacioneintegracion.Parcial.Event.Entity.MiddleTables.ParticipantEvent.ParticipantEvent;
import com.implementacioneintegracion.Parcial.Media.Entity.EventMedia;
import com.implementacioneintegracion.Parcial.Ticket.Entity.TicketType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Event")
@Data
public class Event {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @Size(min = 1, max = 30)
    private String name;

    @Column(name = "date_time")
    private Date dateTime;

    @Column(name = "location")
    @Size(min = 1, max = 50)
    private String location;

    @OneToMany(mappedBy = "id.event", fetch = FetchType.LAZY)
    private List<TicketType> ticketTypes;

    @OneToMany(mappedBy = "id.event", fetch = FetchType.LAZY)
    private List<EventMedia> eventMedia;

    @OneToMany(mappedBy = "id.event", fetch = FetchType.LAZY)
    private List<OrganizerEvent> eventOrganizers;

    @OneToMany(mappedBy = "id.event", fetch = FetchType.LAZY)
    private List<ParticipantEvent> eventParticipants;

//    @OneToMany(mappedBy = "id.event", fetch = FetchType.LAZY)
//    private List<AttendeeEvent> attendees;
}
