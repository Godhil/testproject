package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.RequestArchive;

public interface IRequestsArchiveService {

    RequestArchive addRequestArchive(RequestArchive requestArchive);

    void delete(Integer id);

    RequestArchive editRequestArhive(RequestArchive requestArchive);

    Iterable<RequestArchive> requestsArchiveList();

    RequestArchive getRequestArchiveById(Integer id);

}
