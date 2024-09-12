package com.implementacioneintegracion.Parcial.Media;

import com.implementacioneintegracion.Parcial.Event.Entity.Event;
import com.implementacioneintegracion.Parcial.Event.EventDAO;
import com.implementacioneintegracion.Parcial.Media.DTO.MediaEventCreationDTO;
import com.implementacioneintegracion.Parcial.Media.DTO.MediaModelCreationDTO;
import com.implementacioneintegracion.Parcial.Media.Entity.EventMedia.EventMedia;
import com.implementacioneintegracion.Parcial.Media.Entity.EventMedia.EventMediaCompositeKey;
import com.implementacioneintegracion.Parcial.Media.Entity.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MediaControllerImplementation implements MediaController {
    private final MediaService mediaService;

    @Autowired
    public MediaControllerImplementation(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    @Override
    public ResponseEntity<List<Media>> getAllMedia() {
        return ResponseEntity.ok(mediaService.getAllMedia());
    }

    @Override
    public ResponseEntity<List<Media>> getEventMedia(int eventId) {
        return ResponseEntity.ok(mediaService.getEventMedia(eventId));
    }

    @Override
    public ResponseEntity<Void> addMediaEvent(int eventId, MediaEventCreationDTO media) {
        mediaService.addMediaEvent(eventId, media);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<Void> deleteMediaEvent(int eventId, long mediaId) {
        mediaService.deleteMediaEvent(eventId, mediaId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<List<Media>> getParticipantMedia(int participantId) {
        return ResponseEntity.ok(mediaService.getParticipantMedia(participantId));
    }

    @Override
    public ResponseEntity<Void> addMediaModel(int participantId, MediaModelCreationDTO media) {
        mediaService.addMediaParticipant(participantId, media);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<Void> deleteMediaParticipant(int participantId, long mediaId) {
        mediaService.deleteMediaParticipant(participantId, mediaId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
