package com.implementacioneintegracion.Parcial.Media;

import com.implementacioneintegracion.Parcial.Media.DTO.MediaEventCreationDTO;
import com.implementacioneintegracion.Parcial.Media.DTO.MediaEventResponseDTO;
import com.implementacioneintegracion.Parcial.Media.DTO.MediaModelCreationDTO;
import com.implementacioneintegracion.Parcial.Media.DTO.MediaModelResponseDTO;
import com.implementacioneintegracion.Parcial.Media.Entity.Media;

import java.util.List;

public interface MediaService {
    List<Media> getAllMedia();

    // Event Media
    List<MediaEventResponseDTO> getEventMedia(int eventId);
    void addEventMedia(int eventId, MediaEventCreationDTO media);
    void deleteEventMedia(int eventId, long mediaId);

    // Participant Media
    List<MediaModelResponseDTO> getModelMedia(int model);
    void addModelMedia(int modelId, MediaModelCreationDTO media);
    void deleteModelMedia(int modelId, long mediaId);
}
