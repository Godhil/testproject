package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.AdPlace;

import java.util.List;

public interface IAdPlaceService {

    AdPlace saveAdPlace(AdPlace adPlace);

    Iterable<AdPlace> adPlaceListWithDelete();

    AdPlace getById(Integer id);

    List<AdPlace> adPlaceList(String activeStatus);

    AdPlace setDeleteStatus(AdPlace adPlace);
}
