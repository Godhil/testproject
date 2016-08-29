package com.marennikov.app.testproject.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marennikov.app.testproject.entity.Photo;
import com.marennikov.app.testproject.service.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PhotoController {

    private IPhotoService photoService;

    @Autowired
    public void setPhotoService(IPhotoService photoService) {
        this.photoService = photoService;
    }

    @RequestMapping(value = "/photo", method = RequestMethod.GET)
    public Iterable<Photo> photoList() {
        return photoService.photoList();
    }


}
