package com.marennikov.app.testproject.service.impl;

import com.marennikov.app.testproject.entity.Request;
import com.marennikov.app.testproject.repository.IRequestRepository;
import com.marennikov.app.testproject.service.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestImpl implements IRequestService {

    private IRequestRepository requestsRepository;

    @Autowired
    public void setRequestsRepository(IRequestRepository requestsRepository) {
        this.requestsRepository = requestsRepository;
    }

    @Override
    public Request saveRequest(Request request) {
        return requestsRepository.saveAndFlush(request);
    }

    @Override
    public Iterable<Request> requestsListWithDelete() {
        return requestsRepository.findAll();
    }

    @Override
    public Request getById(Integer id) {
        return requestsRepository.findOne(id);
    }

    @Override
    public List<Request> requestList(String activeStatus) {
        return requestsRepository.findAllByActiveStatus(activeStatus);
    }

    @Override
    public Request setDeleteActiveStatus(Request request) {
        request.setActiveStatus("Delete");
        return requestsRepository.saveAndFlush(request);
    }

    @Override
    public Iterable<Request> requestListByRequesterIdNotApproved(Integer id, String status) {
        return requestsRepository.findAllByRequesterIdAndStatusNotLike(id, status);
    }

    @Override
    public Iterable<Request> requestListByRequesterIdApproved(Integer id, String status) {
        return requestsRepository.findAllByRequesterIdAndStatus(id, status);
    }

    @Override
    public Iterable<Request> requestListByStatus(String status) {
        return requestsRepository.findAllByStatus(status);
    }

    @Override
    public Request getRequestByAdPlaceId(Integer id) {
        return requestsRepository.findOneByAdPlaceId(id);
    }

    @Override
    public Request getRequestByAdConstructionId(Integer id) {
        return requestsRepository.findOneByAdConstructionId(id);
    }
}
