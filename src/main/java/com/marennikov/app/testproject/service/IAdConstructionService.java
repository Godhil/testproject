package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.AdConstruction;
import com.marennikov.app.testproject.entity.AdPlace;

import java.util.List;

public interface IAdConstructionService {

    AdConstruction addAdConstruction(AdConstruction adConstruction);

    AdConstruction editAdConstruction(AdConstruction adConstruction);

    Iterable<AdConstruction> adConstructionListWithDelete();

    List<AdConstruction> adConstructionList(String activeStatus);

    AdConstruction getById(Integer id);

    AdConstruction setDeleteStatus(AdConstruction adConstruction);
}
