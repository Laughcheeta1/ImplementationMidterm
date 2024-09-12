package com.implementacioneintegracion.Parcial.Media;

import com.implementacioneintegracion.Parcial.Media.DTO.MediaEventCreationDTO;
import com.implementacioneintegracion.Parcial.Media.DTO.MediaModelCreationDTO;
import com.implementacioneintegracion.Parcial.Media.Entity.Media;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MediaController {
    ResponseEntity<List<Media>> getAllMedia();

    // Event Media
    ResponseEntity<List<Media>> getEventMedia(int eventId);
    ResponseEntity<Void> addMediaEvent(int eventId, MediaEventCreationDTO media);
    ResponseEntity<Void> deleteMediaEvent(int eventId, long mediaID);

    // Participant Media
    ResponseEntity<List<Media>> getParticipantMedia(int participantId);
    ResponseEntity<Void> addMediaModel(int modelId, MediaModelCreationDTO media);
    ResponseEntity<Void> deleteMediaParticipant(int participantId, long mediaId);
}