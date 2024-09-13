package com.implementacioneintegracion.Parcial.Media.Entity.MediaInPortfolio;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MediaInPortfolioDAO extends JpaRepository<MediaInPortfolio, MediaInPortfolioCompositeKey> {
    List<MediaInPortfolio>findById_Person_Id(String personId);
}
