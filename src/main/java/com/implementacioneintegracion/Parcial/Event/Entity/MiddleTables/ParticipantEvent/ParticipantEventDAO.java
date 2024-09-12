package com.implementacioneintegracion.Parcial.Event.Entity.MiddleTables.ParticipantEvent;

import com.implementacioneintegracion.Parcial.Event.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantEventDAO extends JpaRepository<ParticipantEvent, ParticipantEventCompositeKey> {
    int countById_Event(Event event);
}
