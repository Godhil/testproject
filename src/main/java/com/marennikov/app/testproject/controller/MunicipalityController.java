package com.marennikov.app.testproject.controller;

import com.marennikov.app.testproject.entity.Municipality;
import com.marennikov.app.testproject.service.IMunicipalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("municipality")
public class MunicipalityController {

    private IMunicipalityService municipalityService;

    private Municipality itemById ;

    private Municipality itemByName;

    @Autowired
    public void setMunicipalityService(IMunicipalityService municipalityService) {
        this.municipalityService = municipalityService;
    }

    //Список муниципальных образований(без отключенных)
    @RequestMapping("municipalities")
    public String municipalityListWithOutDelete(Model model) {
        model.addAttribute("municipalityList", municipalityService.municipalityList(null));
        return "municipality/municipalities";
    }

    //Новое МО
    @RequestMapping("municipality")
    public String newMunicipality(Model model) {
        model.addAttribute("municipality", new Municipality());
        return "municipality/municipality";
    }

    //Редактирование МО
    @RequestMapping("municipality/{id}")
    public String editMunicipality(@PathVariable Integer id, Model model) {
        model.addAttribute("municipality", municipalityService.getById(id));
        return "municipality/municipality";
    }

    //сохранение
    @RequestMapping(value = "/municipalities", method = RequestMethod.POST)
    public String saveMunicipality(Municipality municipality) {

        itemByName = municipalityService.getByName(municipality.getName());

        if (municipality.getId() != null) {

            itemById = municipalityService.getById(municipality.getId());

            if ((itemById.getName().equals(municipality.getName())) ||
                    (itemByName == null)) {

                municipalityService.saveMunicipality(municipality);
                return "redirect:/municipality/municipalities";

            } else return "redirect:/municipality/municipality/" + municipality.getId();

        } else if (itemByName == null) {

            municipalityService.saveMunicipality(municipality);
            return "redirect:/municipality/municipalities";
        }

        return "redirect:/municipality/municipality";
    }

    //отключение(установить флаг "Delete")
    @RequestMapping(value = "/municipality/delete/{id}", method = RequestMethod.POST)
    public String setDelete(@PathVariable Integer id) {
        Municipality municipality = municipalityService.getById(id);
        municipalityService.setDeleteStatus(municipality);
        return "redirect:/municipality/municipalities";
    }
}
