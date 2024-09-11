package com.implementacioneintegracion.Parcial.Person.Entity.CategoryParticipant;

import com.implementacioneintegracion.Parcial.Category.Entity.Category;
import com.implementacioneintegracion.Parcial.Person.Entity.Person;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Category_Participant")
@Data
public class CategoryParticipant {
    @Id
    private CategoryParticipantCompositeKey id;
}
