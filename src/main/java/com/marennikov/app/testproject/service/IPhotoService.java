package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.Photo;

public interface IPhotoService {

    Photo addPhoto(Photo photo);

    void delete(Integer id);

    Photo editPhoto(Photo photo);

    Iterable<Photo> photoList();

}
