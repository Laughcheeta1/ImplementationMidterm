package com.implementacioneintegracion.Parcial.Person.Entity.CategoryParticipant;

import com.implementacioneintegracion.Parcial.Category.Entity.Category;
import com.implementacioneintegracion.Parcial.Person.Entity.Person;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class CategoryParticipantCompositeKey implements Serializable {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_category", referencedColumnName = "id")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_participant", referencedColumnName = "id")
    private Person person;
}
