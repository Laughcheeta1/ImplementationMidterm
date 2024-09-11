package com.implementacioneintegracion.Parcial.Category;

import com.implementacioneintegracion.Parcial.Category.Entity.Category;
import com.implementacioneintegracion.Parcial.Person.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryDAO extends JpaRepository<Category, Short> {
    @Query(value = "SELECT person FROM CategoryParticipant catPar INNER JOIN  catPar.person person WHERE catPar.category = :categoryId")
    List<Person> getParticipantsInCategory(short categoryId);
}
