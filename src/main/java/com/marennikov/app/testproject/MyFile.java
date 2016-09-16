package com.marennikov.app.testproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marennikov.app.testproject.entity.*;
import com.marennikov.app.testproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;

@Component
public class MyFile {

    @Autowired
    private IMunicipalityService municipalityService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IAdPlaceService adPlaceService;

    @Autowired
    private IAdConstructionService adConstructionService;

    @Autowired
    private IRequestService requestService;

    @Autowired
    private IPhotoService photoService;

    @Autowired
    private IRequestsArchiveService requestsArchiveService;

    @PostConstruct
    public void main() {
        try {
            addData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        ClassForParseJsonFile objects = mapper.readValue(file(), ClassForParseJsonFile.class);

        //municipality
        for(Municipality municipality : objects.getMunicipality()) {
            municipalityService.saveMunicipality(municipality);
        }

        //user
        for(User user : objects.getUser()) {
            userService.saveUser(user);
        }

        //adPlace
        for(AdPlace adPlace : objects.getAdPlace()) {
            adPlaceService.saveAdPlace(adPlace);
        }

        //adConstruction
        for(AdConstruction adConstruction : objects.getAdConstruction()) {
            adConstructionService.saveAdConstruction(adConstruction);
        }

        //request
        for(Request request : objects.getRequest()) {
            requestService.saveRequest(request);
        }

        //photo
        for(Photo photo : objects.getPhoto()) {
            photoService.savePhoto(photo);
        }
//
//        //requestArchive
//        for(RequestArchive requestArchive : objects.getRequestArchive()) {
//            requestsArchiveService.saveRequestArchive(requestArchive);
//        }
    }

    private File file() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("myFile.json").getFile());
        return file;
    }
}
