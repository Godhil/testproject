package com.marennikov.app.testproject.service.impl;

import com.marennikov.app.testproject.entity.Photo;
import com.marennikov.app.testproject.repository.IPhotoRepository;
import com.marennikov.app.testproject.service.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhotoImpl implements IPhotoService {

    private IPhotoRepository photoRepository;

    @Autowired
    public void setPhotoRepository(IPhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    @Override
    public Iterable<Photo> photoList() {
        return photoRepository.findAll();
    }

    @Override
    public Photo getPhotoById(Integer id) {
        return photoRepository.findOne(id);
    }

    @Override
    public Photo savePhoto(Photo photo) {
        return photoRepository.save(photo);
    }
}
