package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.Request;

import java.util.List;

public interface IRequestService {

    Request saveRequest(Request request);

    List<Request> requestsListWithDelete();

    Request getById(Integer id);

    List<Request> requestList(String activeStatus);

    Request setDeleteActiveStatus(Request request);

    List<Request> requestListByRequesterIdNotApproved(Integer id, String status);

    List<Request> requestListByRequesterIdApproved(Integer id, String status);

    List<Request> requestListByStatus(String status);

    Request getRequestByAdPlaceId(Integer id);

    Request getRequestByAdConstructionId(Integer id);
}
