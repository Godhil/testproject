package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.AdsConstruction;

public interface IAdsConstructionService {

    Iterable<AdsConstruction> adsConstructionList();

    AdsConstruction getAdsConstructionById(Integer id);

    AdsConstruction saveAdsConstruction(AdsConstruction adsConstruction);
}
