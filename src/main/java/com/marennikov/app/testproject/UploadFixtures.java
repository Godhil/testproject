package com.marennikov.app.testproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marennikov.app.testproject.entity.*;
import com.marennikov.app.testproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;

@Component
public class UploadFixtures {

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

        ParseJsonFixtures objects = mapper.readValue(getFile(), ParseJsonFixtures.class);

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
    }

    private File getFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource("fixtures.json").getFile());
    }
}
