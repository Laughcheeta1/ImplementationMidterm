package com.implementacioneintegracion.Parcial.Media;

import com.implementacioneintegracion.Parcial.Media.DTO.MediaEventCreationDTO;
import com.implementacioneintegracion.Parcial.Media.DTO.MediaEventResponseDTO;
import com.implementacioneintegracion.Parcial.Media.DTO.MediaModelCreationDTO;
import com.implementacioneintegracion.Parcial.Media.DTO.MediaModelResponseDTO;
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
    public ResponseEntity<List<MediaEventResponseDTO>> getEventMedia(int eventId) {
        return ResponseEntity.ok(mediaService.getEventMedia(eventId));
    }

    @Override
    public ResponseEntity<Void> addEventMedia(int eventId, MediaEventCreationDTO media) {
        mediaService.addEventMedia(eventId, media);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<Void> deleteEventMedia(int eventId, long mediaId) {
        mediaService.deleteEventMedia(eventId, mediaId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<List<MediaModelResponseDTO>> getModelMedia(int participantId) {
        return ResponseEntity.ok(mediaService.getModelMedia(participantId));
    }

    @Override
    public ResponseEntity<Void> addModelMedia(int participantId, MediaModelCreationDTO media) {
        mediaService.addModelMedia(participantId, media);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<Void> deleteModelMedia(int participantId, long mediaId) {
        mediaService.deleteModelMedia(participantId, mediaId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
