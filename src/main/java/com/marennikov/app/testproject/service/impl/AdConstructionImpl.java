package com.marennikov.app.testproject.service.impl;

import com.marennikov.app.testproject.entity.AdConstruction;
import com.marennikov.app.testproject.repository.IAdConstructionRepository;
import com.marennikov.app.testproject.service.IAdConstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdConstructionImpl implements IAdConstructionService {

    @Autowired
    private IAdConstructionRepository adConstructionRepository;

    @Autowired
    public void setAdConstructionRepository(IAdConstructionRepository adConstructionRepository) {
        this.adConstructionRepository = adConstructionRepository;
    }

    @Override
    public AdConstruction addAdConstruction(AdConstruction adConstruction) {
        AdConstruction saveAdConstruction = adConstructionRepository.saveAndFlush(adConstruction);

        return saveAdConstruction;
    }

    @Override
    public void delete(Integer id) {
        adConstructionRepository.delete(id);
    }

    @Override
    public AdConstruction editAdConstruction(AdConstruction adConstruction) {
        return adConstructionRepository.saveAndFlush(adConstruction);
    }

    @Override
    public Iterable<AdConstruction> adConstructionList() {
        return adConstructionRepository.findAll();
    }

}
