package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.AdConstruction;

public interface IAdConstructionService {

    AdConstruction addAdConstruction(AdConstruction adConstruction);

    void delete(Integer id);

    AdConstruction editAdConstruction(AdConstruction adConstruction);

    Iterable<AdConstruction> adConstructionList();

}
