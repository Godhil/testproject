package com.marennikov.app.testproject.repository;

import com.marennikov.app.testproject.entity.AdPlace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAdPlaceRepository extends JpaRepository<AdPlace, Integer> {

    List<AdPlace> findAllByActiveStatus(String activeStatus);
}
