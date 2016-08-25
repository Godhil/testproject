package com.marennikov.app.testproject.repository;

import com.marennikov.app.testproject.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPhotoRepository extends JpaRepository<Photo, Integer> {
}
