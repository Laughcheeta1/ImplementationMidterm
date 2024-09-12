package com.implementacioneintegracion.Parcial.Event;

import com.implementacioneintegracion.Parcial.Event.DTO.EventCreationDTO;
import com.implementacioneintegracion.Parcial.Event.DTO.EventUpdateDTO;
import com.implementacioneintegracion.Parcial.Event.Entity.Event;
import com.implementacioneintegracion.Parcial.Person.DTO.AttendeeResponseDTO;
import com.implementacioneintegracion.Parcial.Person.DTO.OrganizerResponseDTO;
import com.implementacioneintegracion.Parcial.Person.DTO.ParticipantResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
@Validated
public class EventControllerImplementation implements EventController {
    private final EventService eventService;

    @Autowired
    public EventControllerImplementation(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    @GetMapping("")
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Event> getEvent(@PathVariable("id") int id) {
        return ResponseEntity.ok(eventService.getEvent(id));
    }

    @Override
    @PostMapping("")
    public ResponseEntity<Void> createEvent(@Valid @RequestBody EventCreationDTO event) {
        eventService.createEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable("id") int id) {
        eventService.deleteEvent(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEvent(@PathVariable("id") int id, @RequestBody EventUpdateDTO update) {
        eventService.updateEvent(id, update);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // Attendees
    @Override
    @GetMapping("{eventId}/attendees")
    public ResponseEntity<List<AttendeeResponseDTO>> getAttendees(@PathVariable("eventId") int id) {
        return ResponseEntity.ok(eventService.getAttendees(id));
    }

    // Organizers
    @Override
    @GetMapping("/{eventId}/organizers")
    public ResponseEntity<List<OrganizerResponseDTO>> getOrganizers(@PathVariable("eventId") int id) {
        return ResponseEntity.ok(eventService.getOrganizers(id));
    }

    @Override
    @PostMapping("/{eventId}/organizers")
    public ResponseEntity<Void> addOrganizers(@PathVariable("eventId") int eventId, @RequestBody List<String> organizersIds) {
        eventService.addOrganizers(eventId, organizersIds);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @DeleteMapping("{eventId}/organizer/{id}")
    public ResponseEntity<Void> deleteOrganizer(@PathVariable("eventId") int eventId, @PathVariable("id") String idOrganizer) {
        eventService.deleteOrganizer(eventId, idOrganizer);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // Participants
    @Override
    @GetMapping("{eventId}/participants")
    public ResponseEntity<List<ParticipantResponseDTO>> getParticipants(@PathVariable("eventId") int id) {
        return ResponseEntity.ok(eventService.getParticipants(id));
    }

    @Override
    @PostMapping("{eventId}/participants")
    public ResponseEntity<Void> addParticipants(@PathVariable("eventId") int eventId, @RequestBody List<String> participantsIds) {
        eventService.addParticipants(eventId, participantsIds);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    @DeleteMapping("{eventId}/participant/{id}")
    public ResponseEntity<Void> deleteParticipant(@PathVariable("eventId") int eventId, @PathVariable("id") String participantId) {
        eventService.deleteParticipant(eventId, participantId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
