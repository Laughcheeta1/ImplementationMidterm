package com.implementacioneintegracion.Parcial.Category;

import com.implementacioneintegracion.Parcial.Category.Entity.Category;
import com.implementacioneintegracion.Parcial.Person.DTO.ParticipantResponseDTO;
import com.implementacioneintegracion.Parcial.Person.Entity.Person;
import com.implementacioneintegracion.Parcial.Person.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryService {
    private final CategoryDAO categoryDAO;
    private final PersonDao personDao;

    @Autowired
    public CategoryServiceImplementation(CategoryDAO categoryDAO, PersonDao personDao) {
        this.categoryDAO = categoryDAO;
        this.personDao = personDao;
    }


    @Override
    public List<Category> getAllCategories() {
        return categoryDAO.findAll();
    }

    @Override
    public void addCategory(Category category) {
        category.setName(category.getName().toLowerCase());
        if (categoryDAO.existsByName(category.getName()))
            throw new RuntimeException("This category already exists");  // TODO Create an exception for this

        categoryDAO.save(category);
    }

    @Override
    public void deleteCategory(short categoryId) {
        categoryDAO.deleteById(categoryId);
    }

    @Override
    public List<ParticipantResponseDTO> getParticipantsInCategory(short categoryId) {
        List<Person> participants = categoryDAO.getParticipantsInCategory(categoryId);
        System.out.println(participants);

        return participants.stream().map(
                participant -> ParticipantResponseDTO.builder()
                        .id(participant.getId())
                        .name(participant.getName())
                        .userName(participant.getUserName())
                        .categories(
                                personDao.getCategoryNamesFromParticipant(participant.getId())
                        ).build()
        ).toList();
    }
}
