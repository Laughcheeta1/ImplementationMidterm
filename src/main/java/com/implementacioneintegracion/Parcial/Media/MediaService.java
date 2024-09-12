package com.implementacioneintegracion.Parcial.Media;

import com.implementacioneintegracion.Parcial.Media.Entity.Media;

import java.util.List;

public interface MediaService {
    List<Media> getAllMedia();

    // Event Media
    List<Media> getEventMedia(int eventId);
    void addMediaEvent(int eventId, Media media);
    void deleteMediaEvent(int eventId, long mediaId);

    // Participant Media
    List<Media> getParticipantMedia(int participantId);
    void addMediaParticipant(int participantId, Media media);
    void deleteMediaParticipant(int participantId, long mediaId);
}
