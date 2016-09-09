package com.marennikov.app.testproject.service.impl;

import com.marennikov.app.testproject.entity.RequestArchive;
import com.marennikov.app.testproject.repository.IRequestsArchiveRepository;
import com.marennikov.app.testproject.service.IRequestsArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestsArchiveImpl implements IRequestsArchiveService {

    @Autowired
    private IRequestsArchiveRepository requestsArchiveRepository;

    @Autowired
    public void setRequestsArchiveRepository(IRequestsArchiveRepository requestsArchiveRepository) {
        this.requestsArchiveRepository = requestsArchiveRepository;
    }

    @Override
    public RequestArchive addRequestArchive(RequestArchive requestArchive) {
        RequestArchive addRequestArchive = requestsArchiveRepository.saveAndFlush(requestArchive);

        return addRequestArchive;
    }

    @Override
    public void delete(Integer id) {
        requestsArchiveRepository.delete(id);
    }

    @Override
    public RequestArchive editRequestArhive(RequestArchive requestArchive) {
        return requestsArchiveRepository.saveAndFlush(requestArchive);
    }

    @Override
    public Iterable<RequestArchive> requestsArchiveListWithDelete() {
        return requestsArchiveRepository.findAll();
    }

    @Override
    public List<RequestArchive> requestArchiveList(String activeStatus) {
        return requestsArchiveRepository.findAllByActiveStatus(activeStatus);
    }

    @Override
    public RequestArchive getById(Integer id) {
        return requestsArchiveRepository.findOne(id);
    }
}
