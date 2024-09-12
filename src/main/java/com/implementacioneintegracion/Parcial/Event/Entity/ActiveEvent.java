package com.implementacioneintegracion.Parcial.Event.Entity;

import jakarta.persistence.*;
import lombok.Data;


// TODO delete this entity both here and the database
@Entity
@Table(name = "Active_Event")
@Data
public class ActiveEvent {
    @Id
    @OneToOne(fetch = jakarta.persistence.FetchType.EAGER)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    public Event event;
}
