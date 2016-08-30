package com.marennikov.app.testproject.repository;

import com.marennikov.app.testproject.entity.AdPlace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdPlaceRepository extends JpaRepository<AdPlace, Integer> {
}
