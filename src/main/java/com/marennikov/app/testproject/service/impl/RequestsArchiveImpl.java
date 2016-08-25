package com.marennikov.app.testproject.service.impl;

import com.marennikov.app.testproject.entity.RequestsArchive;
import com.marennikov.app.testproject.repository.IRequestsArchiveRepository;
import com.marennikov.app.testproject.service.IRequestsArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestsArchiveImpl implements IRequestsArchiveService {

    private IRequestsArchiveRepository requestsArchiveRepository;

    @Autowired
    public void setRequestsArchiveRepository(IRequestsArchiveRepository requestsArchiveRepository) {
        this.requestsArchiveRepository = requestsArchiveRepository;
    }

    @Override
    public Iterable<RequestsArchive> requestsArchiveList() {
        return requestsArchiveRepository.findAll();
    }

    @Override
    public RequestsArchive getRequestsArchiveById(Integer id) {
        return requestsArchiveRepository.findOne(id);
    }

    @Override
    public RequestsArchive saveRequestsArchive(RequestsArchive requestsArchive) {
        return requestsArchiveRepository.save(requestsArchive);
    }
}
