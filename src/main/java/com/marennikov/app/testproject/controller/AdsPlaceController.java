package com.marennikov.app.testproject.controller;

import com.marennikov.app.testproject.entity.AdPlace;
import com.marennikov.app.testproject.service.IAdPlaceService;
import com.marennikov.app.testproject.service.IMunicipalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdsPlaceController {

    private IAdPlaceService adPlaceService;

    private IMunicipalityService municipalityService;

    @Autowired
    public void setAdPlaceService(IAdPlaceService adPlaceService){
        this.adPlaceService = adPlaceService;
    }

    @Autowired
    public void setMunicipalityService(IMunicipalityService municipalityService) {
        this.municipalityService = municipalityService;
    }

    //список РК, без отключенных
    @RequestMapping("places")
    public String adPlaceListWithOutDelete(Model model) {
        model.addAttribute("adPlaceList", adPlaceService.adPlaceList(null));
        return "adplace/places";
    }

    //сохранение
    @RequestMapping(value = "/places", method = RequestMethod.POST)
    public String saveAdPlace(AdPlace adPlace){
        adPlaceService.saveAdPlace(adPlace);
        return "redirect:/places";
    }

    //Новое РМ
    @RequestMapping("place")
    public String newAdPlace(Model model) {
        model.addAttribute("adPlace", new AdPlace());
        model.addAttribute("municipalityList", municipalityService.municipalityList(null));
        return "adplace/place";
    }

    //Редактирование РМ
    @RequestMapping(value = "place/{id}")
    public String editAdPlace(@PathVariable Integer id, Model model) {
        model.addAttribute("adPlace", adPlaceService.getById(id));
        model.addAttribute("municipalityList", municipalityService.municipalityList(null));
        return "adplace/place";
    }

    //отключение(установить флаг "Delete")
    @RequestMapping(value = "/place/delete/{id}", method = RequestMethod.POST)
    public String setDelete(@PathVariable Integer id){
        AdPlace adPlace = adPlaceService.getById(id);
        adPlaceService.setDeleteStatus(adPlace);
        return "redirect:/places";
    }
}
