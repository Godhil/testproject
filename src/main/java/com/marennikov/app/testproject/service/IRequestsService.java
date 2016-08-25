package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.Requests;

public interface IRequestsService {

    Iterable<Requests> requestsList();

    Requests getRequestsById(Integer id);

    Requests saveRequests(Requests requests);

}
