package com.implementacioneintegracion.Parcial.Media;

import com.implementacioneintegracion.Parcial.Media.Entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MediaDAO extends JpaRepository<Media, Long> {
}
