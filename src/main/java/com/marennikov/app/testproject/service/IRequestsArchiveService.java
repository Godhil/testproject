package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.RequestsArchive;

public interface IRequestsArchiveService {

    Iterable<RequestsArchive> requestsArchiveList();

    RequestsArchive getRequestsArchiveById(Integer id);

    RequestsArchive saveRequestsArchive(RequestsArchive requestsArchive);
}
