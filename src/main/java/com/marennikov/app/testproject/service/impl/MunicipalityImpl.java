package com.marennikov.app.testproject.service.impl;

import com.marennikov.app.testproject.entity.Municipality;
import com.marennikov.app.testproject.repository.IMunicipalityRepository;
import com.marennikov.app.testproject.service.IMunicipalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipalityImpl implements IMunicipalityService {


    private IMunicipalityRepository municipalityRepository;

    @Autowired
    public void setMunicipalityRepository(IMunicipalityRepository municipalityRepository) {
        this.municipalityRepository = municipalityRepository;
    }


    @Override
    public Municipality saveMunicipality(Municipality municipality) {
        return municipalityRepository.saveAndFlush(municipality);
    }

    @Override
    public Iterable<Municipality> municipalityListWithDelete() {
        return municipalityRepository.findAll();
    }

    @Override
    public List<Municipality> municipalityList(String activeStatus) {
        return municipalityRepository.findAllByActiveStatus(activeStatus);
    }

    @Override
    public Municipality getById(Integer id) {
        return municipalityRepository.findOne(id);
    }

    @Override
    public Municipality setDeleteStatus(Municipality municipality) {
        municipality.setActiveStatus("Delete");
        return municipalityRepository.saveAndFlush(municipality);
    }
}
