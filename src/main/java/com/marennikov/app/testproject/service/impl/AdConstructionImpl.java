package com.marennikov.app.testproject.service.impl;

import com.marennikov.app.testproject.entity.AdConstruction;
import com.marennikov.app.testproject.repository.IAdConstructionRepository;
import com.marennikov.app.testproject.service.IAdConstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdConstructionImpl implements IAdConstructionService {

    private IAdConstructionRepository adConstructionRepository;

    @Autowired
    public void setAdConstructionRepository(IAdConstructionRepository adConstructionRepository) {
        this.adConstructionRepository = adConstructionRepository;
    }

    @Override
    public AdConstruction saveAdConstruction(AdConstruction adConstruction) {
        return adConstructionRepository.saveAndFlush(adConstruction);
    }

    @Override
    public List<AdConstruction> adConstructionListWithDelete() {
        return adConstructionRepository.findAll();
    }

    @Override
    public List<AdConstruction> adConstructionList(String activeStatus) {
        return adConstructionRepository.findAllByActiveStatus(activeStatus);
    }

    @Override
    public AdConstruction getById(Integer id) {
        return adConstructionRepository.findOne(id);
    }

    @Override
    public AdConstruction setDeleteStatus(AdConstruction adConstruction) {
        adConstruction.setActiveStatus("Delete");
        return adConstructionRepository.saveAndFlush(adConstruction);
    }

}
