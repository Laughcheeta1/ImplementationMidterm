package com.implementacioneintegracion.Parcial.Event.Entity;

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

    @OneToMany(mappedBy = "ticketTypeCompositeKey.event", fetch = FetchType.LAZY)
    private List<TicketType> ticketTypes;
}
