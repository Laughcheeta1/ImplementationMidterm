package com.implementacioneintegracion.Parcial.Event.Entity.MiddleTables.OrganizerEvent;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizerEventDAO extends JpaRepository<OrganizerEvent, OrganizerEventCompositeKey> {
}
