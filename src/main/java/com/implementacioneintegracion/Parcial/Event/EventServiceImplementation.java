package com.implementacioneintegracion.Parcial.Event;

import com.implementacioneintegracion.Parcial.Event.DTO.EventCreationDTO;
import com.implementacioneintegracion.Parcial.Event.DTO.EventUpdateDTO;
import com.implementacioneintegracion.Parcial.Event.Entity.Event;
import com.implementacioneintegracion.Parcial.Event.Entity.MiddleTables.OrganizerEvent.OrganizerEvent;
import com.implementacioneintegracion.Parcial.Event.Entity.MiddleTables.OrganizerEvent.OrganizerEventCompositeKey;
import com.implementacioneintegracion.Parcial.Event.Entity.MiddleTables.OrganizerEvent.OrganizerEventDAO;
import com.implementacioneintegracion.Parcial.Event.Entity.MiddleTables.ParticipantEvent.ParticipantEvent;
import com.implementacioneintegracion.Parcial.Event.Entity.MiddleTables.ParticipantEvent.ParticipantEventCompositeKey;
import com.implementacioneintegracion.Parcial.Event.Entity.MiddleTables.ParticipantEvent.ParticipantEventDAO;
import com.implementacioneintegracion.Parcial.Person.DTO.AttendeeResponseDTO;
import com.implementacioneintegracion.Parcial.Person.DTO.OrganizerResponseDTO;
import com.implementacioneintegracion.Parcial.Person.DTO.ParticipantResponseDTO;
import com.implementacioneintegracion.Parcial.Person.Entity.Person;
import com.implementacioneintegracion.Parcial.Person.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class EventServiceImplementation implements EventService {
    private final EventDAO eventDAO;
    private final PersonDao personDao;
    private final OrganizerEventDAO organizerEventDAO;
    private final ParticipantEventDAO participantEventDAO;

    @Autowired
    public EventServiceImplementation(EventDAO eventDAO, PersonDao personDao, OrganizerEventDAO organizerEventDAO, ParticipantEventDAO participantEventDAO) {
        this.eventDAO = eventDAO;
        this.personDao = personDao;
        this.organizerEventDAO = organizerEventDAO;
        this.participantEventDAO = participantEventDAO;
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
        // TODO  changes this exceptions
        Event event = eventDAO.findById(eventId).orElseThrow(() -> new RuntimeException("event not found"));

        List<OrganizerEvent> organizers = organizerId.stream().map(id -> {
            Person org = personDao.findById(id).orElseThrow(() -> new RuntimeException("The organizer has not been found"));

            OrganizerEventCompositeKey orgEventComp = new OrganizerEventCompositeKey();
            orgEventComp.setEvent(event);
            orgEventComp.setPerson(org);

            OrganizerEvent orgEvent = new OrganizerEvent();
            orgEvent.setId(orgEventComp);

            return orgEvent;
        }).toList();

        organizerEventDAO.saveAll(organizers);
    }

    @Override
    public void deleteOrganizer(int eventId, String idOrganizer) {
        // TODO
        Event event = eventDAO.findById(eventId).orElseThrow(() -> new RuntimeException("Couldn't find event"));
        // TODO
        Person organizer = personDao.findById(idOrganizer).orElseThrow(() -> new RuntimeException("Couldn't find organizer"));

        OrganizerEventCompositeKey orgEventComp = new OrganizerEventCompositeKey();
        orgEventComp.setPerson(organizer);
        orgEventComp.setEvent(event);

        organizerEventDAO.deleteById(orgEventComp);
    }


    // Participants
    @Override
    public List<ParticipantResponseDTO> getParticipants(int eventId) {
        Event event = eventDAO.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));  // TODO change exception

        return event.getEventParticipants().stream().map(participantEvent -> {
                    Person p = participantEvent.getId().getPerson();
                    return ParticipantResponseDTO.builder()
                            .id(p.getId())
                            .name(p.getName())
                            .userName(p.getUserName())
                            .categories(personDao.getCategoryNamesFromParticipant(p.getId()))
                            .build();
                }
        ).toList();
    }

    @Override
    public void addParticipants(int eventId, List<String> participantsIds) {
        // TODO  changes this exceptions
        Event event = eventDAO.findById(eventId).orElseThrow(() -> new RuntimeException("event not found"));

        AtomicInteger counter = new AtomicInteger(participantEventDAO.countById_Event(event) + 1);

        List<ParticipantEvent> organizers = participantsIds.stream().map(id -> {
            Person org = personDao.findById(id).orElseThrow(() -> new RuntimeException("The participant has not been found"));

            ParticipantEventCompositeKey partEventComp = new ParticipantEventCompositeKey();
            partEventComp.setEvent(event);
            partEventComp.setPerson(org);

            ParticipantEvent partEvent = new ParticipantEvent();
            partEvent.setId(partEventComp);
            partEvent.setParticipantNumber(counter.get());
            counter.getAndIncrement();

            return partEvent;
        }).toList();

        participantEventDAO.saveAll(organizers);
    }

    @Override
    public void deleteParticipant(int eventId, String participantId) {
        // TODO
        Event event = eventDAO.findById(eventId).orElseThrow(() -> new RuntimeException("Couldn't find event"));
        // TODO
        Person participant = personDao.findById(participantId).orElseThrow(() -> new RuntimeException("Couldn't find participant"));

        ParticipantEventCompositeKey partEventComp = new ParticipantEventCompositeKey();
        partEventComp.setPerson(participant);
        partEventComp.setEvent(event);

        participantEventDAO.deleteById(partEventComp);
    }
}
