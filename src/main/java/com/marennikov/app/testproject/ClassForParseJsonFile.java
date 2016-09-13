package com.marennikov.app.testproject;

import com.marennikov.app.testproject.entity.*;

import java.util.List;

public class ClassForParseJsonFile {

    private List<Municipality> municipality;

    private List<User> user;

    private List<AdPlace> adPlace;

    private List<AdConstruction> adConstruction;

    private List<Request> request;

    private List<Photo> photo;

    private List<RequestArchive> requestArchive;

    public List<Municipality> getMunicipality() {
        return municipality;
    }

    public void setMunicipality(List<Municipality> municipality) {
        this.municipality = municipality;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<AdPlace> getAdPlace() {
        return adPlace;
    }

    public void setAdPlace(List<AdPlace> adPlace) {
        this.adPlace = adPlace;
    }

    public List<AdConstruction> getAdConstruction() {
        return adConstruction;
    }

    public void setAdConstruction(List<AdConstruction> adConstruction) {
        this.adConstruction = adConstruction;
    }

    public List<Request> getRequest() {
        return request;
    }

    public void setRequest(List<Request> request) {
        this.request = request;
    }

    public List<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }

    public List<RequestArchive> getRequestArchive() {
        return requestArchive;
    }

    public void setRequestArchive(List<RequestArchive> requestArchive) {
        this.requestArchive = requestArchive;
    }
}
