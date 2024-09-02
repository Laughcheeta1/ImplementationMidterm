package com.implementacioneintegracion.Parcial.Ticket.Entity;

import com.implementacioneintegracion.Parcial.Event.Entity.Event;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class TicketTypeCompositeKey implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;
    @Column(name = "ticket_type_id")
    private short ticketTypeId;
}
