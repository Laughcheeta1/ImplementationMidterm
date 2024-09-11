package com.implementacioneintegracion.Parcial.Media.Entity.EventMedia;

import com.implementacioneintegracion.Parcial.Event.Entity.Event;
import com.implementacioneintegracion.Parcial.Media.Entity.Media;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "Event_Media")
@Data
public class EventMedia {
    @Id
    private EventMediaCompositeKey id;

    @Column(name = "part_of_show")
    @Size(min = 1, max = 20)
    private String partOfShow;

    @Column(name = "highlighted")
    private boolean highlighted;
}
