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
    public Request addRequest(Request request) {
        Request addRequest = requestsRepository.saveAndFlush(request);

        return addRequest;
    }

    @Override
    public Request editRequest(Request request) {
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
}
