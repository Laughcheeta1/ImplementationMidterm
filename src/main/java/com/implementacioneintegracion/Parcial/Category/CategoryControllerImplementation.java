package com.implementacioneintegracion.Parcial.Category;

import com.implementacioneintegracion.Parcial.Category.Entity.Category;
import com.implementacioneintegracion.Parcial.Person.DTO.ParticipantResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@Validated
public class CategoryControllerImplementation implements CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryControllerImplementation (CategoryService categoryService)
    {
        this.categoryService = categoryService;
    }


    @Override
    @GetMapping("")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @Override
    @PostMapping("")
    public ResponseEntity<Void> addCategory(@Valid @RequestBody Category category) {
        categoryService.addCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") short categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok().build();
    }

    @Override
    @GetMapping("/participants/{id}")
    public ResponseEntity<List<ParticipantResponseDTO>> getParticipantsInCategory(@PathVariable("id") short categoryId) {
        return ResponseEntity.ok(categoryService.getParticipantsInCategory(categoryId));
    }
}

