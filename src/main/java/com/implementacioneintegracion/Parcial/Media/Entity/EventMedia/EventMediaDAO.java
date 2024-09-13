package com.implementacioneintegracion.Parcial.Media.Entity.EventMedia;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventMediaDAO extends JpaRepository<EventMedia, EventMediaCompositeKey> {
    List<EventMedia> findById_Event(int eventId);
}
