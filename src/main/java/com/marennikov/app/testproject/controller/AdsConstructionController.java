package com.marennikov.app.testproject.controller;

import com.marennikov.app.testproject.entity.AdConstruction;
import com.marennikov.app.testproject.service.IAdConstructionService;
import com.marennikov.app.testproject.service.IAdPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdsConstructionController {

    private IAdConstructionService adConstructionService;

    private IAdPlaceService adPlaceService;

    @Autowired
    public void setAdConstructionService(IAdConstructionService adConstructionService){
        this.adConstructionService = adConstructionService;
    }

    @Autowired
    public void setAdPlaceService(IAdPlaceService adPlaceService) {
        this.adPlaceService = adPlaceService;
    }

    //список РК, без отключенных
    @RequestMapping("constructions")
    public String adConstructionListWithOutDelete(Model model) {
        model.addAttribute("adConstructionList", adConstructionService.adConstructionList(null));
        return "adconstruction/constructions";
    }

    //сохранение и отправка id для создания заявки
    @RequestMapping(value = "/constructions", method = RequestMethod.POST)
    public String saveAdConstruction(AdConstruction adConstruction, Model model){
        adConstructionService.saveAdConstruction(adConstruction);

        model.addAttribute("adPlaceId", adConstruction.getAdPlace().getId());
        model.addAttribute("adConstructionId", adConstruction.getId());

        return "redirect:/new/{adPlaceId}/{adConstructionId}";
    }

    //Создание РК через РМ
    @RequestMapping(value = "construction/{id}")
    public String newAdConstruction(@PathVariable Integer id, Model model) {
        model.addAttribute("adConstruction", new AdConstruction());
        model.addAttribute("adPlaceList", adPlaceService.getById(id));
        return "adconstruction/construction";
    }
//
//    //Редактирование РК
//    @RequestMapping(value = "construction/{id}")
//    public String editAdConstruction(@PathVariable Integer id, Model model) {
//        model.addAttribute("adConstruction", adConstructionService.getById(id));
//        model.addAttribute("adPlaceList", adPlaceService.adPlaceList(null));
//        return "adconstruction/construction";
//    }

    //отключение(установить флаг "Delete")
    @RequestMapping(value = "/construction/delete/{id}", method = RequestMethod.POST)
    public String setDelete(@PathVariable Integer id){
        AdConstruction adConstruction = adConstructionService.getById(id);
        adConstructionService.setDeleteStatus(adConstruction);
        return "redirect:/constructions";
    }
}
