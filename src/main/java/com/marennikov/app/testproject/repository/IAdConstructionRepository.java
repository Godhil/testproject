package com.marennikov.app.testproject.repository;

import com.marennikov.app.testproject.entity.AdConstruction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAdConstructionRepository extends JpaRepository<AdConstruction, Integer> {

    List<AdConstruction> findAllByActiveStatus(String activeStatus);
}
