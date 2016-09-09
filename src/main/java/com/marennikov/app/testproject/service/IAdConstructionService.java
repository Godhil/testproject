package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.AdConstruction;

import java.util.List;

public interface IAdConstructionService {

    AdConstruction addAdConstruction(AdConstruction adConstruction);

    void delete(Integer id);

    AdConstruction editAdConstruction(AdConstruction adConstruction);

    Iterable<AdConstruction> adConstructionListWithDelete();

    List<AdConstruction> adConstructionList(String activeStatus);

    AdConstruction getById(Integer id);
}
