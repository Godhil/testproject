package com.marennikov.app.testproject.repository;

import com.marennikov.app.testproject.entity.AdConstruction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdConstructionRepository extends JpaRepository<AdConstruction, Integer> {
}
