package com.marennikov.app.testproject.controller;

import com.marennikov.app.testproject.entity.AdsPlace;
import com.marennikov.app.testproject.service.IAdsPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdsPlaceController {

    private IAdsPlaceService adsPlaceService;

    @Autowired
    public void setAdsPlaceService(IAdsPlaceService adsPlaceService) {
        this.adsPlaceService = adsPlaceService;
    }

    @RequestMapping(value = "/place", method = RequestMethod.GET)
    public Iterable<AdsPlace> adsPlaceList() {
        return adsPlaceService.adsPlaceList();
    }

}
