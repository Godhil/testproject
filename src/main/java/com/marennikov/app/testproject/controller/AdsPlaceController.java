package com.marennikov.app.testproject.controller;

import com.marennikov.app.testproject.entity.AdPlace;
import com.marennikov.app.testproject.service.IAdPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdsPlaceController {

    private IAdPlaceService adsPlaceService;

    @Autowired
    public void setAdsPlaceService(IAdPlaceService adsPlaceService) {
        this.adsPlaceService = adsPlaceService;
    }

    @RequestMapping(value = "/place", method = RequestMethod.GET)
    public Iterable<AdPlace> adPlaceList() {
        return adsPlaceService.adPlaceList();
    }

    @RequestMapping(value = "/delplace/{id}", method = RequestMethod.GET)
    public void deleteAdPlace(@PathVariable Integer id) {
        adsPlaceService.delete(id);
    }
}
