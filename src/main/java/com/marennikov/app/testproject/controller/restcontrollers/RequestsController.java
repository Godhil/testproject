package com.marennikov.app.testproject.controller.restcontrollers;

import com.marennikov.app.testproject.entity.Request;
import com.marennikov.app.testproject.service.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api")
public class RequestsController {

    private IRequestService requestsService;

    @Autowired
    public void setRequestsService(IRequestService requestsService) {
        this.requestsService = requestsService;
    }

    @RequestMapping("requestListWithDelete")
    @ResponseBody
    public Iterable<Request> requestListWithDelete() {
        return requestsService.requestsListWithDelete();
    }

    @RequestMapping("requestList")
    @ResponseBody
    public List<Request> requestList(String activeStatus) {
        return requestsService.requestList(activeStatus);
    }

    @RequestMapping(value="request", method=RequestMethod.POST)
    @ResponseBody
    public String addRequestArchive(Request request) {
        requestsService.addRequest(request);
        return "Saved Request: " + request.toString();
    }

    @RequestMapping(value="request/edit", method=RequestMethod.POST)
    @ResponseBody
    public String editRequestArchive(Request request) {
        requestsService.editRequest(request);
        return "Saved Request: " + request.toString();
    }

    @RequestMapping("request/{id}")
    @ResponseBody
    public Request getById(@PathVariable Integer id) {
        return requestsService.getById(id);
    }

    @RequestMapping("request/delete/{id}")
    @ResponseBody
    public void deleteById(@PathVariable Integer id) {
        requestsService.delete(id);
    }
}
