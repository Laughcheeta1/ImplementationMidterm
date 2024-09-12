package com.implementacioneintegracion.Parcial.Event;

import com.implementacioneintegracion.Parcial.Event.DTO.EventCreationDTO;
import com.implementacioneintegracion.Parcial.Event.DTO.EventUpdateDTO;
import com.implementacioneintegracion.Parcial.Event.Entity.Event;
import com.implementacioneintegracion.Parcial.Person.DTO.AttendeeResponseDTO;
import com.implementacioneintegracion.Parcial.Person.DTO.OrganizerResponseDTO;
import com.implementacioneintegracion.Parcial.Person.DTO.ParticipantResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EventService {
    List<Event> getAllEvents();

    Event getEvent(int id);

    void createEvent(EventCreationDTO event);

    void deleteEvent(int id);

    void updateEvent(int id, EventUpdateDTO update);

    // Attendees
    List<AttendeeResponseDTO> getAttendees(int eventId);

    // Organizers
    List<OrganizerResponseDTO> getOrganizers(int eventId);

    void addOrganizers(int eventId, List<String> organizerId);

    void deleteOrganizer(int eventId, String idOrganizer);


    // Participants
    List<ParticipantResponseDTO> getParticipants(int eventId);

    void addParticipants(int eventId, List<String> participantsIds);

    void deleteParticipant(int eventId, String participantId);
}
