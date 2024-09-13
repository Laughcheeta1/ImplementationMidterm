package com.implementacioneintegracion.Parcial.Media;

import com.implementacioneintegracion.Parcial.Media.DTO.MediaEventCreationDTO;
import com.implementacioneintegracion.Parcial.Media.DTO.MediaEventResponseDTO;
import com.implementacioneintegracion.Parcial.Media.DTO.MediaModelCreationDTO;
import com.implementacioneintegracion.Parcial.Media.DTO.MediaModelResponseDTO;
import com.implementacioneintegracion.Parcial.Media.Entity.Media;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MediaController {
    ResponseEntity<List<Media>> getAllMedia();

    // Event Media
    ResponseEntity<List<MediaEventResponseDTO>> getEventMedia(int eventId);
    ResponseEntity<Void> addEventMedia(int eventId, MediaEventCreationDTO media);
    ResponseEntity<Void> deleteEventMedia(int eventId, long mediaID);

    // Participant Media
    ResponseEntity<List<MediaModelResponseDTO>> getModelMedia(int modelId);
    ResponseEntity<Void> addModelMedia(int modelId, MediaModelCreationDTO media);
    ResponseEntity<Void> deleteModelMedia(int modelId, long mediaId);
}