package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.Municipality;

import java.util.List;

public interface IMunicipalityService {

    Municipality saveMunicipality(Municipality municipality);

    Iterable<Municipality> municipalityListWithDelete();

    List<Municipality> municipalityList(String activeStatus);

    Municipality getById(Integer id);

    Municipality getByName(String name);

    Municipality setDeleteStatus(Municipality municipality);
}
