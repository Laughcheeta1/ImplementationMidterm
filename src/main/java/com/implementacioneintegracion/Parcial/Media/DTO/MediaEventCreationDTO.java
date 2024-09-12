package com.implementacioneintegracion.Parcial.Media.DTO;

import lombok.Getter;

import java.util.Date;

@Getter
public class MediaEventCreationDTO {
    private boolean highlighted;
    private String partOfShow;
    private String url;
    private char mediaType;
}
