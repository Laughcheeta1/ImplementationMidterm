package com.implementacioneintegracion.Parcial.Person.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Category_Participant")
@Data
public class CategoryParticipant {
    @Id
    private CategoryParticipantCompositeKey id;
}
