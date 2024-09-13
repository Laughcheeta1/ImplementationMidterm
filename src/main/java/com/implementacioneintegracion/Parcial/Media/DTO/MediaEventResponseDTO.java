package com.implementacioneintegracion.Parcial.Media.DTO;

import lombok.Builder;

@Builder
public class MediaEventResponseDTO {
    private long mediaId;
    private String url;
    private char mediaType;
    private String partOfShow;
    private boolean highlighted;
}
