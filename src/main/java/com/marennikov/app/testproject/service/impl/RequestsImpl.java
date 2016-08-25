package com.marennikov.app.testproject.service.impl;

import com.marennikov.app.testproject.entity.Requests;
import com.marennikov.app.testproject.repository.IRequestsRepository;
import com.marennikov.app.testproject.service.IRequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestsImpl implements IRequestsService {

    private IRequestsRepository requestsRepository;

    @Autowired
    public void setRequestsRepository(IRequestsRepository requestsRepository) {
        this.requestsRepository = requestsRepository;
    }

    @Override
    public Iterable<Requests> requestsList() {
        return requestsRepository.findAll();
    }

    @Override
    public Requests getRequestsById(Integer id) {
        return requestsRepository.findOne(id);
    }

    @Override
    public Requests saveRequests(Requests requests) {
        return requestsRepository.save(requests);
    }
}
