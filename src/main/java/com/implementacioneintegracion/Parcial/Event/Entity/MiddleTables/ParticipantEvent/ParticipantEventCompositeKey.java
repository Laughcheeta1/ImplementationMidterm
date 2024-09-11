package com.implementacioneintegracion.Parcial.Event.Entity.MiddleTables.ParticipantEvent;

import com.implementacioneintegracion.Parcial.Event.Entity.Event;
import com.implementacioneintegracion.Parcial.Person.Entity.Person;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


@Embeddable
@EqualsAndHashCode
public class ParticipantEventCompositeKey implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;
}
