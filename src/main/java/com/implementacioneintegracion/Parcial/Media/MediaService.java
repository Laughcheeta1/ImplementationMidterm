package com.implementacioneintegracion.Parcial.Media;

import com.implementacioneintegracion.Parcial.Media.DTO.MediaEventCreationDTO;
import com.implementacioneintegracion.Parcial.Media.DTO.MediaModelCreationDTO;
import com.implementacioneintegracion.Parcial.Media.Entity.Media;

import java.util.List;

public interface MediaService {
    List<Media> getAllMedia();

    // Event Media
    List<Media> getEventMedia(int eventId);
    void addMediaEvent(int eventId, MediaEventCreationDTO media);
    void deleteMediaEvent(int eventId, long mediaId);

    // Participant Media
    List<Media> getParticipantMedia(int participantId);
    void addMediaParticipant(int participantId, MediaModelCreationDTO media);
    void deleteMediaParticipant(int participantId, long mediaId);
}
