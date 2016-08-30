package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.AdConstruction;
import com.marennikov.app.testproject.entity.Municipality;

public interface IMunicipalityService {

    Municipality addMunicipality(Municipality municipality);

    void delete(Integer id);

    Municipality editMunicipality(Municipality municipality);

    Iterable<Municipality> municipalityList();
}
