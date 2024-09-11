package com.implementacioneintegracion.Parcial.Event;

import com.implementacioneintegracion.Parcial.Event.Entity.Event;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EventController {
    ResponseEntity<List<Event>> getAllEvents();

    ResponseEntity<Event> getEvent(int id);

    ResponseEntity<Void> createEvent(Event event);
}
