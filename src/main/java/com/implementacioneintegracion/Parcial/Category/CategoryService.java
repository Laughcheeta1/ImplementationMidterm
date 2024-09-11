package com.implementacioneintegracion.Parcial.Category;

import com.implementacioneintegracion.Parcial.Category.Entity.Category;
import com.implementacioneintegracion.Parcial.Person.DTO.ParticipantResponseDTO;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    void addCategory(Category category);

    void deleteCategory(short categoryId);

    List<ParticipantResponseDTO> getParticipantsInCategory(short categoryId);
}
