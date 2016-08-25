package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.Photo;

public interface IPhotoService {

    Iterable<Photo> photoList();

    Photo getPhotoById(Integer id);

    Photo savePhoto(Photo photo);
}
