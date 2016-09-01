package com.marennikov.app.testproject.controller;

import com.marennikov.app.testproject.entity.Request;
import com.marennikov.app.testproject.service.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestsController {

    private IRequestService requestsService;

    @Autowired
    public void setRequestsService(IRequestService requestsService) {
        this.requestsService = requestsService;
    }

    @RequestMapping(value = "/requests", method = RequestMethod.GET)
    public Iterable<Request> requestsList() {
        return requestsService.requestsList();
    }

    @RequestMapping(value = "/delrequest/{id}", method = RequestMethod.GET)
    public void deleteRequest(@PathVariable Integer id) {
        requestsService.delete(id);
    }
}
