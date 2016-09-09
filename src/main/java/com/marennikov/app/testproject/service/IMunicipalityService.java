package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.Municipality;

import java.util.List;

public interface IMunicipalityService {

    Municipality addMunicipality(Municipality municipality);

    void delete(Integer id);

    Municipality editMunicipality(Municipality municipality);

    Iterable<Municipality> municipalityListWithDelete();

    List<Municipality> municipalityList(String activeStatus);

    Municipality getById(Integer id);
}
