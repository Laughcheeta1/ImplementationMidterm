package com.implementacioneintegracion.Parcial.Event.Entity.MiddleTables.AttendeeEvent;

import com.implementacioneintegracion.Parcial.Event.Entity.Event;
import com.implementacioneintegracion.Parcial.Person.Entity.Person;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@Getter
public class AttendeeEventCompositeKey implements Serializable {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EVENT_ID", referencedColumnName = "id")
    private Event event;
}
