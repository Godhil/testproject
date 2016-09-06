package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.Request;

public interface IRequestService {

    Request addRequest(Request request);

    void delete(Integer id);

    Request editRequest(Request request);

    Iterable<Request> requestsList();

    Request getRequestById(Integer id);

}
