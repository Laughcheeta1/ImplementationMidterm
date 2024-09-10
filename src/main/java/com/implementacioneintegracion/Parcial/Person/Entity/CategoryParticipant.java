package com.implementacioneintegracion.Parcial.Person.Entity;

import com.implementacioneintegracion.Parcial.Category.Entity.Category;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Category_Participant")
@Data
public class CategoryParticipant {
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_category", referencedColumnName = "id")
    private Category category;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_participant", referencedColumnName = "id")
    private Person person;
}
