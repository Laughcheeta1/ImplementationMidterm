package com.implementacioneintegracion.Parcial.Event.DTO;

import lombok.Getter;

import java.util.Date;

@Getter
public class EventUpdateDTO {
    private String name;
    private Date dateTime;
    private String location;
}
