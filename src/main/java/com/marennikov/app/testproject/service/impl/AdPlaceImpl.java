package com.marennikov.app.testproject.service.impl;

import com.marennikov.app.testproject.entity.AdPlace;
import com.marennikov.app.testproject.repository.IAdPlaceRepository;
import com.marennikov.app.testproject.service.IAdPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdPlaceImpl implements IAdPlaceService {

    private IAdPlaceRepository adPlaceRepository;

    @Autowired
    public void setAdsPlaceRepository(IAdPlaceRepository adPlaceRepository) {
        this.adPlaceRepository = adPlaceRepository;
    }


    @Override
    public AdPlace saveAdPlace(AdPlace adPlace) {
        return adPlaceRepository.saveAndFlush(adPlace);
    }

    @Override
    public Iterable<AdPlace> adPlaceListWithDelete() {
        return adPlaceRepository.findAll();
    }

    @Override
    public AdPlace getById(Integer id) {
        return adPlaceRepository.findOne(id);
    }

    @Override
    public List<AdPlace> adPlaceList(String activeStatus) {
        return adPlaceRepository.findAllByActiveStatus(activeStatus);
    }

    @Override
    public AdPlace setDeleteStatus(AdPlace adPlace) {
        adPlace.setActiveStatus("Delete");
        return adPlaceRepository.saveAndFlush(adPlace);
    }
}
