package com.marennikov.app.testproject.repository;

import com.marennikov.app.testproject.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPhotoRepository extends JpaRepository<Photo, Integer> {

    List<Photo> findAllByActiveStatus(String activeStatus);

}
