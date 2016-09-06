package com.marennikov.app.testproject.service.impl;

import com.marennikov.app.testproject.entity.Request;
import com.marennikov.app.testproject.repository.IRequestRepository;
import com.marennikov.app.testproject.service.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestImpl implements IRequestService {

    @Autowired
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
    public void delete(Integer id) {
        requestsRepository.delete(id);
    }

    @Override
    public Request editRequest(Request request) {
        return requestsRepository.saveAndFlush(request);
    }

    @Override
    public Iterable<Request> requestsList() {
        return requestsRepository.findAll();
    }

    @Override
    public Request getRequestById(Integer id) {
        return requestsRepository.findOne(id);
    }
}
