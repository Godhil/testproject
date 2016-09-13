package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.Request;

import java.util.List;

public interface IRequestService {

    Request saveRequest(Request request);

    Iterable<Request> requestsListWithDelete();

    Request getById(Integer id);

    List<Request> requestList(String activeStatus);

    Request setDeleteStatus(Request request);
}
