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
    private ParticipantEventCompositeKey id;

    @Column(name = "participant_number")
    private int participantNumber;
}
