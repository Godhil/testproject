package com.marennikov.app.testproject.repository;

import com.marennikov.app.testproject.entity.AdsPlace;
import org.springframework.data.repository.CrudRepository;

public interface IAdsPlaceRepository extends CrudRepository<AdsPlace, Integer> {
}
