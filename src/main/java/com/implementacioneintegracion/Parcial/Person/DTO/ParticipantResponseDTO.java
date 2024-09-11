package com.implementacioneintegracion.Parcial.Person.DTO;

import lombok.Builder;

import java.util.List;

/**
 * This is the Response Data Transfer Object for the Participant entity
 */
@Builder
public class ParticipantResponseDTO {
    private String id;
    private String name;
    private String userName;
    private List<String> categories;
}
