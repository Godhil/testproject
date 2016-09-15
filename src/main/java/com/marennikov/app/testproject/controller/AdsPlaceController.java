package com.marennikov.app.testproject.controller;

import com.marennikov.app.testproject.entity.AdPlace;
import com.marennikov.app.testproject.entity.Request;
import com.marennikov.app.testproject.service.IAdPlaceService;
import com.marennikov.app.testproject.service.IMunicipalityService;
import com.marennikov.app.testproject.service.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdsPlaceController {

    private IAdPlaceService adPlaceService;

    private IMunicipalityService municipalityService;

    private IRequestService requestService;

    @Autowired
    public void setAdPlaceService(IAdPlaceService adPlaceService){
        this.adPlaceService = adPlaceService;
    }

    @Autowired
    public void setMunicipalityService(IMunicipalityService municipalityService) {
        this.municipalityService = municipalityService;
    }

    @Autowired
    public void setRequestService(IRequestService requestService) {
        this.requestService = requestService;
    }

    //список РК, без отключенных
    @RequestMapping("places")
    public String adPlaceListWithOutDelete(Model model) {
        model.addAttribute("adPlaceList", adPlaceService.adPlaceList(null));
        return "adplace/places";
    }

    //сохранение при создании
    @RequestMapping(value = "/places", method = RequestMethod.POST)
    public String saveAdPlace(AdPlace adPlace, Model model){

        adPlaceService.saveAdPlace(adPlace);
        model.addAttribute("id", adPlace.getId());
        return "redirect:/construction/{id}";
    }

    //сохранение при редактировании
    @RequestMapping(value = "/placeEdit", method = RequestMethod.POST)
    public String saveAfterEdit(
            AdPlace adPlace,
            Request request,
            Model model) {
        adPlaceService.saveAdPlace(adPlace);
        model.addAttribute("requestId", requestService.getRequestByAdPlaceId(adPlace.getId()).getId());
        return "redirect:/edit/{requestId}";
    }

    //Новое РМ
    @RequestMapping("place")
    public String newAdPlace(Model model) {
        model.addAttribute("adPlace", new AdPlace());
        model.addAttribute("municipalityList", municipalityService.municipalityList(null));
        return "adplace/place";
    }

    //Редактирование РМ
    @RequestMapping(value = "placeEdit/{adPlaceId}")
    public String editAdPlace(
            @PathVariable Integer adPlaceId,
            Model model) {
        model.addAttribute("adPlace", adPlaceService.getById(adPlaceId));
        return "adplace/edit";
    }

    //отключение(установить флаг "Delete")
    @RequestMapping(value = "/place/delete/{id}", method = RequestMethod.POST)
    public String setDelete(@PathVariable Integer id){
        AdPlace adPlace = adPlaceService.getById(id);
        adPlaceService.setDeleteStatus(adPlace);
        return "redirect:/places";
    }
}
