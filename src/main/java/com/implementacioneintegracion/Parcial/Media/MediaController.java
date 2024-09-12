package com.implementacioneintegracion.Parcial.Media;

import com.implementacioneintegracion.Parcial.Media.DTO.MediaDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MediaController {
    ResponseEntity<List<MediaDTO>> getAllMedia();

    // Event Media
    ResponseEntity<List<MediaDTO>> getEventMedia(int eventId);
    ResponseEntity<Void> addMediaEvent(int eventId, MediaDTO media);
    ResponseEntity<Void> deleteMediaEvent(int eventId, MediaDTO media);

    // Participant Media
    ResponseEntity<List<MediaDTO>> getParticipantMedia(int participantId);
    ResponseEntity<Void> addMediaParticipant(int participantId, MediaDTO media);
    ResponseEntity<Void> deleteMediaParticipant(int participantId, MediaDTO media);
}