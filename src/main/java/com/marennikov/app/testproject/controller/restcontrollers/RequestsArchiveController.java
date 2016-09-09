package com.marennikov.app.testproject.controller.restcontrollers;

import com.marennikov.app.testproject.entity.RequestArchive;
import com.marennikov.app.testproject.service.IRequestsArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api")
public class RequestsArchiveController {

    private IRequestsArchiveService requestsArchiveService;

    @Autowired
    public void setRequestsArchiveService(IRequestsArchiveService requestsArchiveService) {
        this.requestsArchiveService = requestsArchiveService;
    }

    @RequestMapping("requestArchiveListWithDelete")
    @ResponseBody
    public Iterable<RequestArchive> requestArchiveListWithDelete() {
        return requestsArchiveService.requestsArchiveListWithDelete();
    }

    @RequestMapping("requestArchiveList")
    @ResponseBody
    public List<RequestArchive> requestArchiveList(String activeStatus) {
        return requestsArchiveService.requestArchiveList(activeStatus);
    }

    @RequestMapping(value="requestarchive", method=RequestMethod.POST)
    @ResponseBody
    public String addRequestArchive(RequestArchive requestArchive) {
        requestsArchiveService.addRequestArchive(requestArchive);
        return "Saved Request Archive: " + requestArchive.toString();
    }

    @RequestMapping(value="requestarchive/edit", method=RequestMethod.POST)
    @ResponseBody
    public String editRequestArchive(RequestArchive requestArchive) {
        requestsArchiveService.editRequestArhive(requestArchive);
        return "Saved Request Archive: " + requestArchive.toString();
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
