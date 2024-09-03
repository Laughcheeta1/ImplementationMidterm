package com.implementacioneintegracion.Parcial.Event.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Organizer_Event")
@Data
public class OrganizerEvent {
    @Id
    private OrganizerEventCompositeKey id;
}
