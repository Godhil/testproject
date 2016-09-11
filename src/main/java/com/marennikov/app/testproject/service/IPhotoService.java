package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.Photo;

import java.util.List;

public interface IPhotoService {

    Photo addPhoto(Photo photo);

    Photo editPhoto(Photo photo);

    Iterable<Photo> photoListWithDelete();

    Photo getById(Integer id);

    List<Photo> photoList(String activeStatus);

    Photo setDeleteStatus(Photo photo);
}
