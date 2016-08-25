package com.marennikov.app.testproject.repository;

import com.marennikov.app.testproject.entity.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMunicipalityRepository extends JpaRepository<Municipality, Integer> {
}
