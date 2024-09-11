package com.implementacioneintegracion.Parcial.Category;

import com.implementacioneintegracion.Parcial.Category.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category, Short> {
}
