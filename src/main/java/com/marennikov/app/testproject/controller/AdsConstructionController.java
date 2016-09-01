package com.marennikov.app.testproject.controller;

import com.marennikov.app.testproject.entity.AdConstruction;
import com.marennikov.app.testproject.service.IAdConstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdsConstructionController {

    private IAdConstructionService adConstructionService;

    @Autowired
    public void setAdConstructionService(IAdConstructionService adConstructionService) {
        this.adConstructionService = adConstructionService;
    }

    @RequestMapping(value = "/construction", method = RequestMethod.GET)
    public Iterable<AdConstruction> adConstructionsList() {
        return adConstructionService.adConstructionList();
    }

    @RequestMapping(value = "/delconstruction/{id}", method = RequestMethod.GET)
    public void deleteAdConstrucrion(@PathVariable Integer id) {
        adConstructionService.delete(id);
    }
}
