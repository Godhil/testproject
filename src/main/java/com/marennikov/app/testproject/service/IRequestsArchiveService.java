package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.RequestsArchive;

public interface IRequestsArchiveService {

    RequestsArchive addRequestArchive(RequestsArchive requestsArchive);

    void delete(Integer id);

    RequestsArchive editRequestArhive(RequestsArchive requestsArchive);

    Iterable<RequestsArchive> requestsArchiveList();

}
