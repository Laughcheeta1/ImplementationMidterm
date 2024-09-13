package com.implementacioneintegracion.Parcial.Media.Entity.EventMedia;

import com.implementacioneintegracion.Parcial.Event.Entity.Event;
import com.implementacioneintegracion.Parcial.Media.Entity.Media;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
@Data
@Setter
public class EventMediaCompositeKey implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event", referencedColumnName = "id")
    private Event event;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "media_id", referencedColumnName = "id")
    private Media media;
}
