package com.marennikov.app.testproject.controller.restcontrollers;

import com.marennikov.app.testproject.entity.Municipality;
import com.marennikov.app.testproject.service.IMunicipalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api")
public class MunicipalityController {

    private IMunicipalityService municipalityService;

    @Autowired
    public void setMunicipalityService(IMunicipalityService municipalityService) {
        this.municipalityService = municipalityService;
    }

    @RequestMapping("municipalitylistwithdelete")
    @ResponseBody
    public Iterable<Municipality> municipalityListWithDelete() {
        return municipalityService.municipalityListWithDelete();
    }

    @RequestMapping("municipalitylist")
    @ResponseBody
    public List<Municipality> municipalityList(String activeStatus){
        return municipalityService.municipalityList(activeStatus);
    }

    @RequestMapping(value="municipality", method=RequestMethod.POST)
    @ResponseBody
    public String addMunicipality(Municipality municipality) {
        municipalityService.addMunicipality(municipality);
        return "Saved Municipality: " + municipality.toString();
    }

    @RequestMapping(value = "municipality/edit", method = RequestMethod.POST)
    @ResponseBody
    public String editMunicipality(Municipality municipality) {
        municipalityService.editMunicipality(municipality);
        return "Saved Municipality: " + municipality.toString();
    }

    @RequestMapping("municipality/{id}")
    @ResponseBody
    public Municipality getById(@PathVariable Integer id) {
        return municipalityService.getById(id);
    }

    @RequestMapping("municipality/delete/{id}")
    @ResponseBody
    public void deleteMunicipality(@PathVariable Integer id) {
        municipalityService.delete(id);
    }

}
