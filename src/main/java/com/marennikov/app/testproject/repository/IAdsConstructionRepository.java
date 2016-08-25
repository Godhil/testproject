package com.marennikov.app.testproject.repository;

import com.marennikov.app.testproject.entity.AdsConstruction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdsConstructionRepository extends JpaRepository<AdsConstruction, Integer> {
}
