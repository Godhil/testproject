package com.marennikov.app.testproject.service.impl;

import com.marennikov.app.testproject.entity.RequestsArchive;
import com.marennikov.app.testproject.repository.IRequestsArchiveRepository;
import com.marennikov.app.testproject.service.IRequestsArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestsArchiveImpl implements IRequestsArchiveService {

    @Autowired
    private IRequestsArchiveRepository requestsArchiveRepository;

    @Autowired
    public void setRequestsArchiveRepository(IRequestsArchiveRepository requestsArchiveRepository) {
        this.requestsArchiveRepository = requestsArchiveRepository;
    }


    @Override
    public RequestsArchive addRequestArchive(RequestsArchive requestsArchive) {
        RequestsArchive addRequestsArchive = requestsArchiveRepository.saveAndFlush(requestsArchive);

        return addRequestsArchive;
    }

    @Override
    public void delete(Integer id) {
        requestsArchiveRepository.delete(id);
    }

    @Override
    public RequestsArchive editRequestArhive(RequestsArchive requestsArchive) {
        return requestsArchiveRepository.saveAndFlush(requestsArchive);
    }

    @Override
    public Iterable<RequestsArchive> requestsArchiveList() {
        return requestsArchiveRepository.findAll();
    }
}
