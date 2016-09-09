package com.marennikov.app.testproject.controller.restcontrollers;

import com.marennikov.app.testproject.entity.AdConstruction;
import com.marennikov.app.testproject.service.IAdConstructionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api")
public class AdsConstructionController {

    private IAdConstructionService adConstructionService;

    @Autowired
    public void setAdConstructionService(IAdConstructionService adConstructionService){
        this.adConstructionService = adConstructionService;
    }

    @RequestMapping("adConstructionListWithDelete")
    @ResponseBody
    public Iterable<AdConstruction> adConstructionListWithDelete() {
        return adConstructionService.adConstructionListWithDelete();
    }

    @RequestMapping("adConstructionList")
    @ResponseBody
    public List<AdConstruction> adConstructionList(String activeStatus) {
        return adConstructionService.adConstructionList(activeStatus);
    }

    @RequestMapping(value="adconstruction", method=RequestMethod.POST)
    @ResponseBody
    public String addAdConstruction(AdConstruction adConstruction) {
        adConstructionService.addAdConstruction(adConstruction);
        return "Saved Ad Construction: " + adConstruction.toString();
    }

    @RequestMapping(value="adconstruction/edit", method=RequestMethod.POST)
    @ResponseBody
    public String editAdConstruction(AdConstruction adConstruction) {
        adConstructionService.editAdConstruction(adConstruction);
        return "Saved Ad Construction: " + adConstruction.toString();
    }

    @RequestMapping("adconstruction/{id}")
    @ResponseBody
    public AdConstruction getById(@PathVariable Integer id) {
        return adConstructionService.getById(id);
    }

    @RequestMapping("adconstruction/delete/{id}")
    @ResponseBody
    public void deleteById(@PathVariable Integer id) {
        adConstructionService.delete(id);
    }
}
