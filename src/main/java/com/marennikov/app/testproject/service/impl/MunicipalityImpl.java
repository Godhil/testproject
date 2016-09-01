package com.marennikov.app.testproject.service.impl;

import com.marennikov.app.testproject.entity.Municipality;
import com.marennikov.app.testproject.repository.IMunicipalityRepository;
import com.marennikov.app.testproject.service.IMunicipalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MunicipalityImpl implements IMunicipalityService {

    @Autowired
    private IMunicipalityRepository municipalityRepository;

    @Autowired
    public void setMunicipalityRepository(IMunicipalityRepository municipalityRepository) {
        this.municipalityRepository = municipalityRepository;
    }


    @Override
    public Municipality addMunicipality(Municipality municipality) {
        Municipality addMunicipality = municipalityRepository.saveAndFlush(municipality);

        return addMunicipality;
    }

    @Override
    public void delete(Integer id) {
        municipalityRepository.delete(id);
    }

    @Override
    public Municipality editMunicipality(Municipality municipality) {
        return municipalityRepository.saveAndFlush(municipality);
    }

    @Override
    public Iterable<Municipality> municipalityList() {
        return municipalityRepository.findAll();
    }

    @Override
    public Municipality getById(Integer id) {
        return municipalityRepository.findOne(id);
    }
}
