package com.implementacioneintegracion.Parcial.Event.Entity.MiddleTables.ParticipantEvent;

import com.implementacioneintegracion.Parcial.Event.Entity.Event;
import com.implementacioneintegracion.Parcial.Person.Entity.Person;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Participant_Event")
@Data
public class ParticipantEvent {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", referencedColumnName = "id")
    private Event event;

    @Column(name = "participant_number")
    private int participantNumber;
}
