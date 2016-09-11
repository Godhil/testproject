package com.marennikov.app.testproject.service.impl;

import com.marennikov.app.testproject.entity.Photo;
import com.marennikov.app.testproject.repository.IPhotoRepository;
import com.marennikov.app.testproject.service.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoImpl implements IPhotoService {

    @Autowired
    private IPhotoRepository photoRepository;

    @Autowired
    public void setPhotoRepository(IPhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }


    @Override
    public Photo addPhoto(Photo photo) {
        Photo addPhoto = photoRepository.saveAndFlush(photo);
        return addPhoto;
    }

    @Override
    public Photo editPhoto(Photo photo) {
        return photoRepository.saveAndFlush(photo);
    }

    @Override
    public Iterable<Photo> photoListWithDelete() {
        return photoRepository.findAll();
    }

    @Override
    public Photo getById(Integer id) {
        return photoRepository.findOne(id);
    }

    @Override
    public List<Photo> photoList(String activeStatus) {
        return photoRepository.findAllByActiveStatus(activeStatus);
    }

    @Override
    public Photo setDeleteStatus(Photo photo) {
        photo.setActiveStatus("Delete");
        return photoRepository.saveAndFlush(photo);
    }
}
