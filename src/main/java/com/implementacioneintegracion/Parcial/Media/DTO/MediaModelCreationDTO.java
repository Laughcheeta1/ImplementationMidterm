package com.implementacioneintegracion.Parcial.Media.DTO;

import lombok.Getter;

import java.util.Date;

@Getter
public class MediaModelCreationDTO {
    private Date date;
    private String description;
    private String url;
    private char mediaType;
}
