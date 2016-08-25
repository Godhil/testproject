package com.marennikov.app.testproject.service.impl;

import com.marennikov.app.testproject.entity.AdsConstruction;
import com.marennikov.app.testproject.repository.IAdsConstructionRepository;
import com.marennikov.app.testproject.service.IAdsConstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdsConstructionImpl implements IAdsConstructionService{

    private IAdsConstructionRepository adsConstructionRepository;

    @Autowired
    public void setAdsConstructionRepository(IAdsConstructionRepository adsConstructionRepository) {
        this.adsConstructionRepository = adsConstructionRepository;
    }

    @Override
    public Iterable<AdsConstruction> adsConstructionList() {
        return adsConstructionRepository.findAll();
    }

    @Override
    public AdsConstruction getAdsConstructionById(Integer id) {
        return adsConstructionRepository.findOne(id);
    }

    @Override
    public AdsConstruction saveAdsConstruction(AdsConstruction adsConstruction) {
        return adsConstructionRepository.save(adsConstruction);
    }
}
