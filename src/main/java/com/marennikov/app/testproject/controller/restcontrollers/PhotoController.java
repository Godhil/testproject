package com.marennikov.app.testproject.controller.restcontrollers;

import com.marennikov.app.testproject.entity.Photo;
import com.marennikov.app.testproject.service.IPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api")
public class PhotoController {

    private IPhotoService photoService;

    @Autowired
    public void setPhotoService(IPhotoService photoService) {
        this.photoService = photoService;
    }

    @RequestMapping("photoListWithDelete")
    @ResponseBody
    public Iterable<Photo> photoListWithDelete() {
        return photoService.photoListWithDelete();
    }

    @RequestMapping("photoList")
    @ResponseBody
    public List<Photo> photoList(String activeStatus) {
        return photoService.photoList(activeStatus);
    }

    @RequestMapping(value="photo", method=RequestMethod.POST)
    @ResponseBody
    public String addPhoto(Photo photo) {
        photoService.addPhoto(photo);
        return "Saved Photo: " + photoService.toString();
    }

    @RequestMapping(value="photo/edit", method=RequestMethod.POST)
    @ResponseBody
    public String editPhoto(Photo photo) {
        photoService.editPhoto(photo);
        return "Saved Photo: " + photoService.toString();
    }

    @RequestMapping("photo/{id}")
    @ResponseBody
    public Photo getById(@PathVariable Integer id) {
        return photoService.getById(id);
    }

    @RequestMapping("photo/delete/{id}")
    @ResponseBody
    public void deleteById(@PathVariable Integer id) {
        photoService.delete(id);
    }
}