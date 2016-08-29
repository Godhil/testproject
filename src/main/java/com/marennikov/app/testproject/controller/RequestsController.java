package com.marennikov.app.testproject.controller;

import com.marennikov.app.testproject.entity.Requests;
import com.marennikov.app.testproject.service.IRequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestsController {

    private IRequestsService requestsService;

    @Autowired
    public void setRequestsService(IRequestsService requestsService) {
        this.requestsService = requestsService;
    }

    @RequestMapping(value = "/requests", method = RequestMethod.GET)
    public Iterable<Requests> requestsList() {
        return requestsService.requestsList();
    }

}
