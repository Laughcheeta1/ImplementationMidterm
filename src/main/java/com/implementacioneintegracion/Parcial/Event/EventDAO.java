package com.implementacioneintegracion.Parcial.Event;

import com.implementacioneintegracion.Parcial.Event.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventDAO extends JpaRepository<Event, Integer> {
}
