package com.marennikov.app.testproject.controller;

import com.marennikov.app.testproject.entity.RequestArchive;
import com.marennikov.app.testproject.service.IRequestsArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestsArchiveController {

    private IRequestsArchiveService requestsArchiveService;

    @Autowired
    public void setRequestsArchiveService(IRequestsArchiveService requestsArchiveService) {
        this.requestsArchiveService = requestsArchiveService;
    }

    @RequestMapping(value = "/archive", method = RequestMethod.GET)
    public Iterable<RequestArchive> requestsArchivesList() {
        return requestsArchiveService.requestsArchiveList();
    }

    @RequestMapping(value = "delarchive/{id}", method = RequestMethod.GET)
    public void delRequestFromArchive(@PathVariable Integer id) {
        requestsArchiveService.delete(id);
    }
}
