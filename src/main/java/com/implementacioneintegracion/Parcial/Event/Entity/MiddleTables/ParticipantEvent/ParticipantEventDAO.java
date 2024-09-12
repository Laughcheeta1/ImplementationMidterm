package com.implementacioneintegracion.Parcial.Event.Entity.MiddleTables.ParticipantEvent;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantEventDAO extends JpaRepository<ParticipantEvent, ParticipantEventCompositeKey> {
}
