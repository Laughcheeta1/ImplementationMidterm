package com.implementacioneintegracion.Parcial.Event;

import com.implementacioneintegracion.Parcial.Event.DTO.EventCreationDTO;
import com.implementacioneintegracion.Parcial.Event.DTO.EventUpdateDTO;
import com.implementacioneintegracion.Parcial.Event.Entity.Event;
import com.implementacioneintegracion.Parcial.Person.DTO.AttendeeResponseDTO;
import com.implementacioneintegracion.Parcial.Person.DTO.OrganizerResponseDTO;
import com.implementacioneintegracion.Parcial.Person.DTO.ParticipantResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EventController {
    ResponseEntity<List<Event>> getAllEvents();

    ResponseEntity<Event> getEvent(int id);

    ResponseEntity<Void> createEvent(EventCreationDTO event);

    ResponseEntity<Void> deleteEvent(int id);

    ResponseEntity<Void> updateEvent(int id, EventUpdateDTO update);


    // Attendees
    ResponseEntity<List<AttendeeResponseDTO>> getAttendees(int id);

    // Organizers
    ResponseEntity<List<OrganizerResponseDTO>> getOrganizers(int id);

    ResponseEntity<Void> addOrganizers(int eventId, List<String> organizerId);

    ResponseEntity<Void> deleteOrganizer(int eventId, String idOrganizer);


    // Participants
    ResponseEntity<List<ParticipantResponseDTO>> getParticipants(int id);

    ResponseEntity<Void> addParticipants(int eventId, List<String> participantsIds);

    ResponseEntity<Void> deleteParticipant(int eventId, String participantId);
}
