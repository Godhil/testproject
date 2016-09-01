package com.marennikov.app.testproject.controller;

import com.marennikov.app.testproject.entity.Municipality;
import com.marennikov.app.testproject.service.IMunicipalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class MunicipalityController {

    private IMunicipalityService municipalityService;

    @Autowired
    public void setMunicipalityService(IMunicipalityService municipalityService) {
        this.municipalityService = municipalityService;
    }

    @RequestMapping(value = "/mun", method = RequestMethod.GET)
    public Iterable<Municipality> municipalityList() {
        return municipalityService.municipalityList();
    }

    @RequestMapping(value = "/delmun/{id}", method = RequestMethod.GET)
    public void deleteMunicipality(@PathVariable Integer id) {
        municipalityService.delete(id);
    }
}
