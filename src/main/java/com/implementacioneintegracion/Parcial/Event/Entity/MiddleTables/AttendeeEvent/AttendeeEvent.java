package com.implementacioneintegracion.Parcial.Event.Entity.MiddleTables.AttendeeEvent;

import com.implementacioneintegracion.Parcial.Event.Entity.Event;
import com.implementacioneintegracion.Parcial.Person.Entity.Person;
import com.implementacioneintegracion.Parcial.Ticket.Entity.TicketType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;

@Entity
@Table(name = "Attendee_Event")
@Data
public class AttendeeEvent {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EVENT_ID", referencedColumnName = "id")
    private Event event;

    @Column(name = "ticket_number")
    private int ticketNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns(value = {
            @JoinColumn(name = "ticket_type", referencedColumnName = "ticket_type_id", insertable = false, updatable = false),
            @JoinColumn(name = "event_id", referencedColumnName = "event_id", insertable = false, updatable = false)
    })
    private TicketType ticketType;
}
