package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.AdPlace;

public interface IAdPlaceService {

    AdPlace addAdPlace(AdPlace adPlace);

    void delete(Integer id);

    AdPlace editAdPlace(AdPlace adPlace);

    Iterable<AdPlace> adPlaceList();

    AdPlace getById(Integer id);
}
