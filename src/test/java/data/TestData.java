package data;

import com.marennikov.app.testproject.entity.*;

public class TestData {

    public static int listSizeWithDelete = 3;

    public static int listSizeWithOutDelete = 2;

    public static Municipality municipality() {
        Municipality municipality = new Municipality();
        municipality.setId(1);
        municipality.setName("Municipality");
        return municipality;
    }

    public static Municipality deleteMunicipality() {
        Municipality municipality = new Municipality();
        municipality.setId(2);
        municipality.setName("Municipality2");
        municipality.setActiveStatus("Delete");
        return municipality;
    }

    public static Municipality willBeDeleteMunicipality() {
        Municipality municipality = new Municipality();
        municipality.setId(3);
        municipality.setName("Municipality3");
        return municipality;
    }

    public static User user() {
        User user = new User();
        user.setId(1);
        user.setLogin("User1");
        user.setPassword("User1");
        user.setSurname("User1");
        user.setFirstName("User1");
        user.setSecondName("User1");
        user.setRole(1);
        user.setMunicipality(municipality());
        return user;
    }

    public static User deleteUser() {
        User user = new User();
        user.setId(2);
        user.setLogin("User2");
        user.setPassword("User2");
        user.setSurname("User2");
        user.setFirstName("User2");
        user.setSecondName("User2");
        user.setRole(1);
        user.setMunicipality(municipality());
        user.setActiveStatus("Delete");
        return user;
    }

    public static User willBeDeleteUser() {
        User user = new User();
        user.setId(3);
        user.setLogin("User3");
        user.setPassword("User3");
        user.setSurname("User3");
        user.setFirstName("User3");
        user.setSecondName("User3");
        user.setRole(1);
        user.setMunicipality(municipality());
        return user;
    }

    public static AdPlace adPlace() {
        AdPlace adPlace = new AdPlace();
        adPlace.setId(1);
        adPlace.setOwner("Place Owner");
        adPlace.setAddress("Place Address");
        adPlace.setMunicipality(municipality());
        return adPlace;
    }

    public static AdPlace deleteAdPlace() {
        AdPlace adPlace = new AdPlace();
        adPlace.setId(2);
        adPlace.setOwner("Place Owner2");
        adPlace.setAddress("Place Address2");
        adPlace.setActiveStatus("Delete");
        adPlace.setMunicipality(municipality());
        return adPlace;
    }
    public static AdPlace willBeDeleteAdPlace() {
        AdPlace adPlace = new AdPlace();
        adPlace.setId(3);
        adPlace.setOwner("Place Owner3");
        adPlace.setAddress("Place Address3");
        adPlace.setMunicipality(municipality());
        return adPlace;
    }

    public static AdConstruction adConstruction() {
        AdConstruction adConstruction = new AdConstruction();
        adConstruction.setId(1);
        adConstruction.setOwner("Construction Owner");
        adConstruction.setType("Construction Type");
        adConstruction.setStatus("Construction Status");
        adConstruction.setNumber(1);
        adConstruction.setAdPlace(adPlace());
        adConstruction.setDate("01/01/2016");
        return adConstruction;
    }

    public static AdConstruction deleteAdConstruction() {
        AdConstruction adConstruction = new AdConstruction();
        adConstruction.setId(2);
        adConstruction.setOwner("Construction Owner2");
        adConstruction.setType("Construction Type2");
        adConstruction.setStatus("Construction Status2");
        adConstruction.setNumber(1);
        adConstruction.setAdPlace(adPlace());
        adConstruction.setDate("01/01/2016");
        adConstruction.setActiveStatus("Delete");
        return adConstruction;
    }

    public static AdConstruction willBeDeleteAdConstruction() {
        AdConstruction adConstruction = new AdConstruction();
        adConstruction.setId(3);
        adConstruction.setOwner("Construction Owner3");
        adConstruction.setType("Construction Type3");
        adConstruction.setStatus("Construction Status3");
        adConstruction.setNumber(1);
        adConstruction.setAdPlace(adPlace());
        adConstruction.setDate("01/01/2016");
        return adConstruction;
    }

    public static Request request() {
        Request request = new Request();
        request.setId(1);
        request.setCreateDate("07/01/2016");
        request.setRequester(user());
        request.setStatus("New");
        request.setAdPlaceId(adPlace());
        request.setAdConstruction(adConstruction());
        request.setAssignee(user());
        request.setProcessingDate("08/01/2016");
        request.setVersion(1);
        request.setRejected("");
        request.setActual(true);
        return request;
    }

    public static Request deleteRequest() {
        Request request = new Request();
        request.setId(2);
        request.setCreateDate("08/02/2016");
        request.setRequester(user());
        request.setStatus("Reject");
        request.setAdPlaceId(adPlace());
        request.setAdConstruction(adConstruction());
        request.setAssignee(user());
        request.setProcessingDate("08/01/2016");
        request.setVersion(1);
        request.setRejected("Reject");
        request.setActual(false);
        request.setActiveStatus("Delete");
        return request;
    }

    public static Request willBeDeleteRequest() {
        Request request = new Request();
        request.setId(3);
        request.setCreateDate("08/02/2016");
        request.setRequester(user());
        request.setStatus("Reject");
        request.setAdPlaceId(adPlace());
        request.setAdConstruction(adConstruction());
        request.setAssignee(user());
        request.setProcessingDate("08/01/2016");
        request.setVersion(1);
        request.setRejected("");
        request.setActual(true);
        return request;
    }

    public static Photo photo() {
        Photo photo = new Photo();
        photo.setId(1);
        photo.setPath("Photo1");
        photo.setRequests(request());
        return photo;
    }

    public static Photo deletePhoto() {
        Photo photo = new Photo();
        photo.setId(2);
        photo.setPath("Photo2");
        photo.setRequests(request());
        photo.setActiveStatus("Delete");
        return photo;
    }

    public static Photo willBeDeletePhoto() {
        Photo photo = new Photo();
        photo.setId(3);
        photo.setPath("Photo3");
        photo.setRequests(request());
        return photo;
    }

    public static RequestArchive requestArchive() {
        RequestArchive requestArchive = new RequestArchive();
        requestArchive.setId(1);
        requestArchive.setCreateDate("08/02/2016");
        requestArchive.setRequester(1);
        requestArchive.setRequest(request());
        requestArchive.setAdPlaceId(3);
        requestArchive.setAdConstructionId(3);
        requestArchive.setAssignee(1);
        requestArchive.setProcessingDate("08/03/2016");
        requestArchive.setVersion(1);
        requestArchive.setRejected(null);
        requestArchive.setActual(true);
        return requestArchive;
    }

    public static RequestArchive deleteRequestArchive() {
        RequestArchive requestArchive = new RequestArchive();
        requestArchive.setId(2);
        requestArchive.setCreateDate("08/02/2016");
        requestArchive.setRequester(1);
        requestArchive.setRequest(request());
        requestArchive.setAdPlaceId(3);
        requestArchive.setAdConstructionId(3);
        requestArchive.setAssignee(1);
        requestArchive.setProcessingDate("08/03/2016");
        requestArchive.setVersion(44);
        requestArchive.setRejected("Rejected");
        requestArchive.setActual(false);
        requestArchive.setActiveStatus("Delete");
        return requestArchive;
    }
    public static RequestArchive willBeDeleteRequestArchive() {
        RequestArchive requestArchive = new RequestArchive();
        requestArchive.setId(3);
        requestArchive.setCreateDate("08/02/2016");
        requestArchive.setRequester(1);
        requestArchive.setRequest(request());
        requestArchive.setAdPlaceId(3);
        requestArchive.setAdConstructionId(3);
        requestArchive.setAssignee(1);
        requestArchive.setProcessingDate("08/03/2016");
        requestArchive.setVersion(44);
        requestArchive.setRejected("Rejected");
        requestArchive.setActual(false);
        return requestArchive;
    }
}
