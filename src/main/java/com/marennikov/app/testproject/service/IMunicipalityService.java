package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.Municipality;

public interface IMunicipalityService {

    Iterable<Municipality> municipalityList();

    Municipality getMunicipalityById(Integer id);

    Municipality saveMunicipality(Municipality municipality);
}
