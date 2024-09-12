package com.implementacioneintegracion.Parcial.Media.DTO;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MediaDTO {
    private String url;
    private char media_type;
}
