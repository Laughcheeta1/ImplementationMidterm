package com.implementacioneintegracion.Parcial.Event.Entity.MiddleTables.OrganizerEvent;

import com.implementacioneintegracion.Parcial.Event.Entity.Event;
import com.implementacioneintegracion.Parcial.Person.Entity.Person;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Organizer_Event")
@Data
public class OrganizerEvent {
    @Id
    private OrganizerEventCompositeKey id;
}
