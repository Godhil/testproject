package com.marennikov.app.testproject.controller;

import com.marennikov.app.testproject.entity.Municipality;
import com.marennikov.app.testproject.entity.Users;
import com.marennikov.app.testproject.service.IMunicipalityService;
import com.marennikov.app.testproject.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

}
