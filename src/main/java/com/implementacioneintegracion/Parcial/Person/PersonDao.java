package com.implementacioneintegracion.Parcial.Person;

import com.implementacioneintegracion.Parcial.Person.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonDao extends JpaRepository<Person, String> {
    @Query(value = "SELECT category.name FROM CategoryParticipant catPar INNER JOIN catPar.id.category category WHERE catPar.id.person = :participantId")
    List<String> getCategoryNamesFromParticipant(String participantId);
}
