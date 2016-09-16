package com.marennikov.app.testproject;

import com.marennikov.app.testproject.entity.*;
import com.marennikov.app.testproject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;


//@Component
public class DataInsert implements ApplicationListener<ContextRefreshedEvent> {

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

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {

        //Municipality
        Municipality municipality = new Municipality();
        municipality.setName("One");

        municipalityService.saveMunicipality(municipality);

        //User
        User user = new User();
        user.setLogin("Qwerty");
        user.setPassword("123456");
        user.setSurname("Ivanov");
        user.setFirstName("Ivan");
        user.setSecondName("Ivanovich");
        user.setRole("1");
        user.setMunicipality(municipality);

        User user2 = new User();
        user2.setLogin("Asdfg");
        user2.setPassword("123456");
        user2.setSurname("Pupkin");
        user2.setFirstName("Vasilii");
        user2.setSecondName("Vasilievich");
        user2.setRole("2");
        user2.setMunicipality(municipality);

        User user3 = new User();
        user3.setLogin("Wop");
        user3.setPassword("123456");
        user3.setSurname("Wop");
        user3.setFirstName("Pop");
        user3.setSecondName("WOW");
        user3.setRole("2");
        user3.setMunicipality(municipality);

        userService.saveUser(user);
        userService.saveUser(user2);
        userService.saveUser(user3);

        //AdPlace
        AdPlace adPlace = new AdPlace();
        adPlace.setMunicipality(municipality);
        adPlace.setAddress("Lenina 25");
        adPlace.setOwner("Lenin V.I.");

        adPlaceService.saveAdPlace(adPlace);

        //AdConstruction
        AdConstruction adConstruction = new AdConstruction();
        adConstruction.setOwner("Loshkin A.A.");
        adConstruction.setAdPlace(adPlace);
        adConstruction.setNumber(1);
        adConstruction.setStatus("Empty");
        adConstruction.setType("Banner");
        adConstruction.setDate("01/01/2016");

        adConstructionService.saveAdConstruction(adConstruction);

        //Request
        Request request = new Request();

        request.setCreateDate("07/01/2016");
        request.setRequester(user);
        request.setStatus("Reject");
        request.setAdPlace(adPlace);
        request.setAdConstruction(adConstruction);
        request.setAssignee(user2);
        request.setProcessingDate("08/01/2016");
        request.setVersion(1);
        request.setRejected("Все плохо");
        request.setActual(false);

        requestService.saveRequest(request);

        //Photo

        Photo photo = new Photo();
        photo.setPath("/photo/");
        photo.setRequests(request);

        Photo photo2 = new Photo();
        photo2.setPath("/photo/");
        photo2.setRequests(request);

        photoService.savePhoto(photo);
        photoService.savePhoto(photo2);

        //RequestArchive
        RequestArchive requestArchive = new RequestArchive();
        requestArchive.setCreateDate("04/01/2016");
        requestArchive.setRequester(user);
        requestArchive.setRequest(request);
        requestArchive.setAdPlace(adPlace);
        requestArchive.setAdConstructionId(adConstruction);
        requestArchive.setAssignee(user);
        requestArchive.setProcessingDate("05/01/2016");
        requestArchive.setVersion(1);
        requestArchive.setRejected(null);
        requestArchive.setStatus("true");

        requestsArchiveService.saveRequestArchive(requestArchive);
    }

}
