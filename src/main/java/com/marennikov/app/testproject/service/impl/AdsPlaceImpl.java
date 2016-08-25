package com.marennikov.app.testproject.service.impl;

import com.marennikov.app.testproject.entity.AdsPlace;
import com.marennikov.app.testproject.repository.IAdsPlaceRepository;
import com.marennikov.app.testproject.service.IAdsPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdsPlaceImpl implements IAdsPlaceService {

    private IAdsPlaceRepository adsPlaceRepository;

    @Autowired
    public void setAdsPlaceRepository(IAdsPlaceRepository adsPlaceRepository) {
        this.adsPlaceRepository = adsPlaceRepository;
    }

    @Override
    public Iterable<AdsPlace> adsPlaceList() {
        return adsPlaceRepository.findAll();
    }

    @Override
    public AdsPlace getAdsPlaceById(Integer id) {
        return adsPlaceRepository.findOne(id);
    }

    @Override
    public AdsPlace saveAdsPlace(AdsPlace adsPlace) {
        return adsPlaceRepository.save(adsPlace);
    }

}
