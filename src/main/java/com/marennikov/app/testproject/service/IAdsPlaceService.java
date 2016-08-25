package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.AdsPlace;

public interface IAdsPlaceService {

    Iterable<AdsPlace> adsPlaceList();

    AdsPlace getAdsPlaceById(Integer id);

    AdsPlace saveAdsPlace(AdsPlace adsPlace);
}
