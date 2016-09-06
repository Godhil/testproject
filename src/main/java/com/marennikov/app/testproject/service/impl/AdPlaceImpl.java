package com.marennikov.app.testproject.service.impl;

import com.marennikov.app.testproject.entity.AdPlace;
import com.marennikov.app.testproject.repository.IAdPlaceRepository;
import com.marennikov.app.testproject.service.IAdPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdPlaceImpl implements IAdPlaceService {

    @Autowired
    private IAdPlaceRepository adPlaceRepository;

    @Autowired
    public void setAdsPlaceRepository(IAdPlaceRepository adPlaceRepository) {
        this.adPlaceRepository = adPlaceRepository;
    }


    @Override
    public AdPlace addAdPlace(AdPlace adPlace) {
        AdPlace saveAdPlace = adPlaceRepository.saveAndFlush(adPlace);

        return saveAdPlace;
    }

    @Override
    public void delete(Integer id) {
        adPlaceRepository.delete(id);
    }

    @Override
    public AdPlace editAdPlace(AdPlace adPlace) {
        return adPlaceRepository.saveAndFlush(adPlace);
    }

    @Override
    public Iterable<AdPlace> adPlaceList() {
        return adPlaceRepository.findAll();
    }

    @Override
    public AdPlace getById(Integer id) {
        return adPlaceRepository.findOne(id);
    }
}
