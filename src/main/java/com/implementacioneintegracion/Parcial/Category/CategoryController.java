package com.implementacioneintegracion.Parcial.Category;

import com.implementacioneintegracion.Parcial.Category.Entity.Category;
import com.implementacioneintegracion.Parcial.Person.DTO.ParticipantResponseDTO;
import com.implementacioneintegracion.Parcial.Person.Entity.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryController {
    /**
     * Get all categories
     * @return List of categories
     */
    ResponseEntity<List<Category>> getAllCategories();

    /**
     * Add a category
     * @param category the category to add
     */
    ResponseEntity<Void> addCategory(Category category);

    /**
     * Delete a category given the id in the path
     * @param categoryId the id of the category to delete
     */
    ResponseEntity<Void> deleteCategory(short categoryId);

    /**
     * Get all participants that are in a category
     * @param categoryId the id of the desired category
     * @return List of participants that are in that category
     */
    ResponseEntity<List<ParticipantResponseDTO>> getParticipantsInCategory(short categoryId);
}