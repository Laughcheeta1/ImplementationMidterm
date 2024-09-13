package com.implementacioneintegracion.Parcial.Media.DTO;

import lombok.Builder;

import java.util.Date;

@Builder
public class MediaModelResponseDTO {
    private int mediaId;
    private Date date;
    private String description;
    private String url;
    private char mediaType;
}
