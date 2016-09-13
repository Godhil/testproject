package com.marennikov.app.testproject.repository;

import com.marennikov.app.testproject.entity.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMunicipalityRepository extends JpaRepository<Municipality, Integer> {

    List<Municipality> findAllByActiveStatus(String activeStatus);
}
