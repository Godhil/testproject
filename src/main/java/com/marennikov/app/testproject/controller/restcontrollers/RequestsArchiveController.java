package com.marennikov.app.testproject.controller.restcontrollers;

import com.marennikov.app.testproject.entity.RequestArchive;
import com.marennikov.app.testproject.service.IRequestsArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api")
public class RequestsArchiveController {

    private IRequestsArchiveService requestsArchiveService;

    @Autowired
    public void setRequestsArchiveService(IRequestsArchiveService requestsArchiveService) {
        this.requestsArchiveService = requestsArchiveService;
    }

    @RequestMapping("requestarchivelist")
    @ResponseBody
    public Iterable<RequestArchive> requestArchiveList() {
        return requestsArchiveService.requestsArchiveList();
    }

    @RequestMapping(value="requestarchive", method=RequestMethod.POST)
    @ResponseBody
    public String addRequestArchive(RequestArchive requestArchive) {
        requestsArchiveService.addRequestArchive(requestArchive);
        return "Saved person: " + requestArchive.toString();
    }

    @RequestMapping("requestarchive/{id}")
    @ResponseBody
    public RequestArchive getById(@PathVariable Integer id) {
        return requestsArchiveService.getById(id);
    }

    @RequestMapping("requestarchive/delete/{id}")
    @ResponseBody
    public void deleteById(@PathVariable Integer id) {
        requestsArchiveService.delete(id);
    }
}
