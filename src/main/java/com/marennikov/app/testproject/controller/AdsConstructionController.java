package com.marennikov.app.testproject.controller;

import com.marennikov.app.testproject.entity.AdsConstruction;
import com.marennikov.app.testproject.service.IAdsConstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdsConstructionController {

    private IAdsConstructionService adsConstructionService;

    @Autowired
    public void setAdsConstructionService(IAdsConstructionService adsConstructionService) {
        this.adsConstructionService = adsConstructionService;
    }

    @RequestMapping(value = "/construction", method = RequestMethod.GET)
    public Iterable<AdsConstruction> adsConstructionsList() {
        return adsConstructionService.adsConstructionList();
    }

    @RequestMapping(value = "/construction/2", method = RequestMethod.GET)
    public AdsConstruction adsConstructionById() {
        return adsConstructionService.getAdsConstructionById(2);
    }

}
