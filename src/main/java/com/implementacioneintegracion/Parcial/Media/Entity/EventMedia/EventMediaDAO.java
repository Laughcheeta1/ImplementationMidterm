package com.implementacioneintegracion.Parcial.Media.Entity.EventMedia;

import com.implementacioneintegracion.Parcial.Event.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventMediaDAO extends JpaRepository<EventMedia, EventMediaCompositeKey> {
    List<EventMedia> findById_Event_Id(int eventId);
}
