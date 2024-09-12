package com.implementacioneintegracion.Parcial.Media;

import com.implementacioneintegracion.Parcial.Media.Entity.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MediaControllerImplementation implements MediaController {
    private MediaService mediaService;

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
    public ResponseEntity<Void> addMediaEvent(int eventId, Media media) {
        Media m = new Media();
        m.setUrl(media.getUrl());
        m.setMediaType(media.getMediaType());

        mediaService.addMediaEvent(eventId, m);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<Void> deleteMediaEvent(int eventId, long mediaId) {


        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<List<Media>> getParticipantMedia(int participantId) {
        return null;
    }

    @Override
    public ResponseEntity<Void> addMediaParticipant(int participantId, Media media) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteMediaParticipant(int participantId, long mediaId) {
        return null;
    }
}
