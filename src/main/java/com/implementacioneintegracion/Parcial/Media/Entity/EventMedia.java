package com.implementacioneintegracion.Parcial.Media.Entity;

import com.implementacioneintegracion.Parcial.Event.Entity.Event;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name = "Event_Media")
@Data
public class EventMedia {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event", referencedColumnName = "id")
    private Event event;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "media_id", referencedColumnName = "id")
    private Media media;

    @Column(name = "part_of_show")
    @Size(min = 1, max = 20)
    private String partOfShow;

    @Column(name = "highlighted")
    private boolean highlighted;
}
