package com.implementacioneintegracion.Parcial.Category;

import com.implementacioneintegracion.Parcial.Category.Entity.Category;
import com.implementacioneintegracion.Parcial.Person.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryDAO extends JpaRepository<Category, Short> {
    boolean existsByName(String name);

    @Query(value = "SELECT p FROM CategoryParticipant catPar INNER JOIN  catPar.id.person p WHERE catPar.id.category.id = :categoryId")
    List<Person> getParticipantsInCategory(@Param("categoryId") Short categoryId);
}
