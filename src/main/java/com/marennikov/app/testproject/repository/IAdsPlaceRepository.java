package com.marennikov.app.testproject.repository;

import com.marennikov.app.testproject.entity.AdsPlace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdsPlaceRepository extends JpaRepository<AdsPlace, Integer> {
}
