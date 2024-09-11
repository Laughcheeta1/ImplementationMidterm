package com.implementacioneintegracion.Parcial.Event.DTO;

import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.Date;

@Getter
public class EventCreationDTO {
    @Size(min = 1, max = 30)
    private String name;

    private Date dateTime;

    @Size(min = 1, max = 50)
    private String location;
}
