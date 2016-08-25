package com.marennikov.app.testproject.service.impl;

import com.marennikov.app.testproject.entity.Municipality;
import com.marennikov.app.testproject.repository.IMunicipalityRepository;
import com.marennikov.app.testproject.service.IMunicipalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MunicipalityImpl implements IMunicipalityService {

    private IMunicipalityRepository municipalityRepository;

    @Autowired
    public void setMunicipalityRepository(IMunicipalityRepository municipalityRepository) {
        this.municipalityRepository = municipalityRepository;
    }


    @Override
    public Iterable<Municipality> municipalityList() {
        return municipalityRepository.findAll();
    }

    @Override
    public Municipality getMunicipalityById(Integer id) {
        return municipalityRepository.findOne(id);
    }

    @Override
    public Municipality saveMunicipality(Municipality municipality) {
        return municipalityRepository.save(municipality);
    }
}
