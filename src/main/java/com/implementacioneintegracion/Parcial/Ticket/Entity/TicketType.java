package com.implementacioneintegracion.Parcial.Ticket.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Ticket_Type")
public class TicketType {
    @Id
    private TicketTypeCompositeKey ticketTypeCompositeKey;
    @Column(name = "name")
    @Size(min = 1, max = 15)
    private String name;
    @Column(name = "price")
    private int price;
    @Column(name = "total_ticket_quantity")
    private int totalTicketQuantity;
    @Column(name = "number_remaining")
    private int numberRemaining;
}
