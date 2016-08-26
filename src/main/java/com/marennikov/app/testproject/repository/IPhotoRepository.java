package com.marennikov.app.testproject.repository;

import com.marennikov.app.testproject.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPhotoRepository extends JpaRepository<Photo, Integer> {

    @Query("from Photo where requests_id = :id")
    Iterable<Photo> findByRequestId(@Param("id") Integer id);
}