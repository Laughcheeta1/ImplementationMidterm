package com.implementacioneintegracion.Parcial.Media;

import com.implementacioneintegracion.Parcial.Media.DTO.MediaDTO;
import com.implementacioneintegracion.Parcial.Media.Entity.Media;

import java.util.List;

public interface MediaService {
    List<MediaDTO> getAllMedia();

    // Event Media
    List<MediaDTO> getEventMedia(int eventId);
    void addMediaEvent(int eventId, Media media);
    void deleteMediaEvent(int eventId, Media media);

    // Participant Media
    List<MediaDTO> getParticipantMedia(int participantId);
    void addMediaParticipant(int participantId, Media media);
    void deleteMediaParticipant(int participantId, Media media);
}
