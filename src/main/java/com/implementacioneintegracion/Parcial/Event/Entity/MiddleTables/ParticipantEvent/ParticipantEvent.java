package com.implementacioneintegracion.Parcial.Event.Entity.MiddleTables.ParticipantEvent;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
