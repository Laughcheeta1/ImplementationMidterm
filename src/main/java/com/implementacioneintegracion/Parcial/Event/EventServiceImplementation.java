package com.implementacioneintegracion.Parcial.Event;

import com.implementacioneintegracion.Parcial.Category.CategoryDAO;
import com.implementacioneintegracion.Parcial.Event.DTO.EventCreationDTO;
import com.implementacioneintegracion.Parcial.Event.DTO.EventUpdateDTO;
import com.implementacioneintegracion.Parcial.Event.Entity.Event;
import com.implementacioneintegracion.Parcial.Event.EventService;
import com.implementacioneintegracion.Parcial.Person.DTO.AttendeeResponseDTO;
import com.implementacioneintegracion.Parcial.Person.DTO.OrganizerResponseDTO;
import com.implementacioneintegracion.Parcial.Person.DTO.ParticipantResponseDTO;
import com.implementacioneintegracion.Parcial.Person.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImplementation implements EventService {
    private final EventDAO eventDAO;

    @Autowired
    public EventServiceImplementation(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventDAO.findAll();
    }

    @Override
    public Event getEvent(int id) {
        return eventDAO.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));  // TODO change exception
    }

    @Override
    public void createEvent(EventCreationDTO event) {
        Event e = new Event();
        e.setName(event.getName());
        e.setDateTime(event.getDateTime());
        e.setLocation(event.getLocation());

        eventDAO.save(e);
    }

    @Override
    public void deleteEvent(int id) {
        eventDAO.deleteById(id);
    }

    @Override
    public void updateEvent(int id, EventUpdateDTO update) {
        Event e = eventDAO.findById(id).orElseThrow(() -> new RuntimeException("Event not found"));  // TODO change exception
        if (update.getName() != null)
            e.setName(update.getName());

        if (update.getDateTime() != null)
            e.setDateTime(update.getDateTime());

        if (update.getLocation() != null)
            e.setLocation(update.getLocation());

        eventDAO.save(e);
    }

    // Attendees
    @Override
    public List<AttendeeResponseDTO> getAttendees(int eventId) {
        Event event = eventDAO.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));  // TODO change exception

        return event.getAttendees().stream().map(attendee -> {
                        Person p = attendee.getId().getPerson();
                        return AttendeeResponseDTO.builder()
                                .id(p.getId())
                                .name(p.getName())
                                .userName(p.getUserName())
                                .build();
                    }
                ).toList();
    }


    // Organizers
    @Override
    public List<OrganizerResponseDTO> getOrganizers(int eventId) {
        Event event = eventDAO.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));  // TODO change exception

        return event.getEventOrganizers().stream().map(organizer -> {
                        Person p = organizer.getId().getPerson();
                        return OrganizerResponseDTO.builder()
                                .id(p.getId())
                                .name(p.getName())
                                .userName(p.getUserName())
                                .build();
                    }
                ).toList();
    }

    @Override
    public void addOrganizers(int eventId, List<String> organizerId) {
        // Use a @Query, as you see more fit

    }

    @Override
    public void deleteOrganizer(int eventId, String idOrganizer) {
        eventDAO.deleteOrganizer(idOrganizer);
    }


    // Participants
    @Override
    public List<ParticipantResponseDTO> getParticipants(int eventId) {
        return eventDAO.getEventParticipants(eventId);
    }

    @Override
    public void addParticipants(int eventId, List<String> participantsIds) {
        eventDAO.addParticipants(participantsIds);
    }

    @Override
    public void deleteParticipant(int eventId, String participantId) {
        eventDAO.deleteParticipant(participantId);
    }
}
