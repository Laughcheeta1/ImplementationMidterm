package com.implementacioneintegracion.Parcial.Media.DTO;

import lombok.Builder;

import java.util.Date;

@Builder
public class MediaModelResponseDTO {
    private Long mediaId;
    private String url;
    private char mediaType;
    private Date date;
    private String description;
}
