package com.implementacioneintegracion.Parcial.Category;

import com.implementacioneintegracion.Parcial.Category.Entity.Category;
import com.implementacioneintegracion.Parcial.Person.DTO.ParticipantResponseDTO;
import com.implementacioneintegracion.Parcial.Person.Entity.Person;

import java.util.List;

public interface CategoryController {
    /**
     * Get all categories
     * @return List of categories
     */
    List<Category> getAllCategories();

    /**
     * Delete a category given the id in the path
     * @param categoryId the id of the category to delete
     */
    void deleteCategory(short categoryId);

    /**
     * Get all participants that are in a category
     * @param categoryId the id of the desired category
     * @return List of participants that are in that category
     */
    List<ParticipantResponseDTO> getParticipantsInCategory(short categoryId);
}
