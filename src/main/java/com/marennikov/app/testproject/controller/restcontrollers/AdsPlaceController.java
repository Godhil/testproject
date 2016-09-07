package com.marennikov.app.testproject.controller.restcontrollers;

import com.marennikov.app.testproject.entity.AdPlace;
import com.marennikov.app.testproject.service.IAdPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api")
public class AdsPlaceController {

    private IAdPlaceService adPlaceService;

    @Autowired
    public void setAdPlaceService(IAdPlaceService adPlaceService){
        this.adPlaceService = adPlaceService;
    }

    @RequestMapping("adplacelist")
    @ResponseBody
    public Iterable<AdPlace> adPlaceList() {
        return adPlaceService.adPlaceList();
    }

    @RequestMapping(value="adplace", method=RequestMethod.POST)
    @ResponseBody
    public String addAdPlace(AdPlace adPlace) {
        adPlaceService.addAdPlace(adPlace);
        return "Saved person: " + adPlace.toString();
    }

    @RequestMapping("adplace/{id}")
    @ResponseBody
    public AdPlace getById(@PathVariable Integer id) {
        return adPlaceService.getById(id);
    }

    @RequestMapping("adplace/delete/{id}")
    @ResponseBody
    public void deleteById(@PathVariable Integer id) {
        adPlaceService.delete(id);
    }

}
