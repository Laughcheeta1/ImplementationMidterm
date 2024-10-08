package com.implementacioneintegracion.Parcial.Media;

import com.implementacioneintegracion.Parcial.Event.Entity.Event;
import com.implementacioneintegracion.Parcial.Event.EventDAO;
import com.implementacioneintegracion.Parcial.Media.DTO.MediaEventCreationDTO;
import com.implementacioneintegracion.Parcial.Media.DTO.MediaEventResponseDTO;
import com.implementacioneintegracion.Parcial.Media.DTO.MediaModelCreationDTO;
import com.implementacioneintegracion.Parcial.Media.DTO.MediaModelResponseDTO;
import com.implementacioneintegracion.Parcial.Media.Entity.EventMedia.EventMedia;
import com.implementacioneintegracion.Parcial.Media.Entity.EventMedia.EventMediaCompositeKey;
import com.implementacioneintegracion.Parcial.Media.Entity.EventMedia.EventMediaDAO;
import com.implementacioneintegracion.Parcial.Media.Entity.Media;
import com.implementacioneintegracion.Parcial.Media.Entity.MediaInPortfolio.MediaInPortfolio;
import com.implementacioneintegracion.Parcial.Media.Entity.MediaInPortfolio.MediaInPortfolioCompositeKey;
import com.implementacioneintegracion.Parcial.Media.Entity.MediaInPortfolio.MediaInPortfolioDAO;
import com.implementacioneintegracion.Parcial.Person.Entity.Person;
import com.implementacioneintegracion.Parcial.Person.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaServiceImplementation implements MediaService {
    private final MediaDAO mediaDAO;
    private final EventDAO eventDAO;
    private final PersonDAO personDAO;
    private final EventMediaDAO eventMediaDAO;
    private final MediaInPortfolioDAO mediaInPortfolioDAO;

    @Autowired
    public MediaServiceImplementation(MediaDAO mediaDAO, EventDAO eventDAO, PersonDAO personDAO, EventMediaDAO eventMediaDAO, MediaInPortfolioDAO mediaInPortfolioDAO) {
        this.mediaDAO = mediaDAO;
        this.eventDAO = eventDAO;
        this.personDAO = personDAO;
        this.eventMediaDAO = eventMediaDAO;
        this.mediaInPortfolioDAO = mediaInPortfolioDAO;
    }

    @Override
    public List<Media> getAllMedia() {
        return mediaDAO.findAll();
    }

    @Override
    public List<MediaEventResponseDTO> getEventMedia(int eventId) {
        List<EventMedia> eventMedia = eventMediaDAO.findById_Event_Id(eventId);

        return eventMedia.stream().map(e -> {
            Media media = e.getId().getMedia();
            return MediaEventResponseDTO.builder()
                    .mediaId(media.getId())
                    .url(media.getUrl())
                    .mediaType(media.getMediaType())
                    .partOfShow(e.getPartOfShow())
                    .highlighted(e.isHighlighted())
                    .build();
        }).toList();
    }

    @Override
    public void addEventMedia(int eventId, MediaEventCreationDTO media) {
        // TODO
        Event event = eventDAO.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));
        Media med = new Media();
        med.setUrl(media.getUrl());
        med.setMediaType(media.getMediaType());

        EventMediaCompositeKey key = new EventMediaCompositeKey();
        key.setEvent(event);
        key.setMedia(med);

        EventMedia eventMedia = new EventMedia();
        eventMedia.setId(key);
        eventMedia.setPartOfShow(media.getPartOfShow());
        eventMedia.setHighlighted(media.isHighlighted());

        // Save the media
        mediaDAO.save(med);
        eventMediaDAO.save(eventMedia);
    }

    @Override
    public void deleteEventMedia(int eventId, long mediaId) {
        // TODO
        Event event = eventDAO.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));
        Media media = mediaDAO.findById(mediaId).orElseThrow(() -> new RuntimeException("Media not found"));

        EventMediaCompositeKey key = new EventMediaCompositeKey();
        key.setEvent(event);
        key.setMedia(media);

        eventMediaDAO.deleteById(key);
        mediaDAO.delete(media);
    }

    @Override
    public List<MediaModelResponseDTO> getModelMedia(String modelId) {
        List<MediaInPortfolio> modelMedia = mediaInPortfolioDAO.findById_Person_Id(modelId);

        return modelMedia.stream().map(e -> {
            Media media = e.getId().getMedia();
            return MediaModelResponseDTO.builder()
                    .mediaId(media.getId())
                    .url(media.getUrl())
                    .mediaType(media.getMediaType())
                    .date(e.getDateOfMedia())
                    .description(e.getDescription())
                    .build();
        }).toList();
    }

    @Override
    public void addModelMedia(String modelId, MediaModelCreationDTO media) {
        // TODO
        Person model = personDAO.findById(modelId).orElseThrow(() -> new RuntimeException("Model not found"));
        Media med = new Media();
        med.setUrl(media.getUrl());
        med.setMediaType(media.getMediaType());

        MediaInPortfolioCompositeKey key = new MediaInPortfolioCompositeKey();
        key.setPerson(model);
        key.setMedia(med);

        MediaInPortfolio modelMedia = new MediaInPortfolio();
        modelMedia.setId(key);
        modelMedia.setDateOfMedia(media.getDate());
        modelMedia.setDescription(media.getDescription());

        // Save the media
        mediaDAO.save(med);
        mediaInPortfolioDAO.save(modelMedia);
    }

    @Override
    public void deleteModelMedia(String modelId, long mediaId) {

    }
}
