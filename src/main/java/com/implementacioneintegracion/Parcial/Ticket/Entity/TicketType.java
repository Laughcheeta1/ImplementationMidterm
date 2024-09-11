package com.implementacioneintegracion.Parcial.Ticket.Entity;

import com.implementacioneintegracion.Parcial.Event.Entity.Event;
import com.implementacioneintegracion.Parcial.Event.Entity.MiddleTables.AttendeeEvent.AttendeeEvent;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "Ticket_Type")
public class TicketType {
    @Id
    private TicketTypeCompositeKey id;

    @Column(name = "name")
    @Size(min = 1, max = 15)
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "total_ticket_quantity")
    private int totalTicketQuantity;

    @Column(name = "number_remaining")
    private int numberRemaining;

    @OneToMany(mappedBy = "ticketType", fetch = FetchType.LAZY)
    private List<AttendeeEvent> ticketBuyers;
}
