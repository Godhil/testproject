package com.marennikov.app.testproject.repository;

import com.marennikov.app.testproject.entity.Photo;
import org.springframework.data.repository.CrudRepository;

public interface IPhotoRepository extends CrudRepository<Photo, Integer> {
}
