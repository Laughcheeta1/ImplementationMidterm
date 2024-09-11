package com.implementacioneintegracion.Parcial.Event;

import com.implementacioneintegracion.Parcial.Event.Entity.Event;
import com.implementacioneintegracion.Parcial.Person.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventDAO extends JpaRepository<Event, Integer> {
    @Query("INSERT INTO ParticipantEvent (person_id, event_id) VALUES (:personId, :eventId)")
    void addOrganizers(List<String> organizerId);
}
