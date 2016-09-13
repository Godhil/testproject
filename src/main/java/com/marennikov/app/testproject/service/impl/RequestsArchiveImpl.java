package com.marennikov.app.testproject.service.impl;

import com.marennikov.app.testproject.entity.RequestArchive;
import com.marennikov.app.testproject.repository.IRequestsArchiveRepository;
import com.marennikov.app.testproject.service.IRequestsArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestsArchiveImpl implements IRequestsArchiveService {

    private IRequestsArchiveRepository requestsArchiveRepository;

    @Autowired
    public void setRequestsArchiveRepository(IRequestsArchiveRepository requestsArchiveRepository) {
        this.requestsArchiveRepository = requestsArchiveRepository;
    }

    @Override
    public RequestArchive saveRequestArchive(RequestArchive requestArchive) {
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

    @Override
    public RequestArchive setDeleteStatus(RequestArchive requestArchive) {
        requestArchive.setActiveStatus("Delete");
        return requestsArchiveRepository.saveAndFlush(requestArchive);
    }
}
