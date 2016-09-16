package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.Request;

import java.util.List;

public interface IRequestService {

    Request saveRequest(Request request);

    Iterable<Request> requestsListWithDelete();

    Request getById(Integer id);

    List<Request> requestList(String activeStatus);

    Request setDeleteActiveStatus(Request request);

    Iterable<Request> requestListByRequesterIdNotApproved(Integer id, String status);

    Iterable<Request> requestListByRequesterIdApproved(Integer id, String status);

    Iterable<Request> requestListByStatus(String status);

    Request getRequestByAdPlaceId(Integer id);

    Request getRequestByAdConstructionId(Integer id);
}
