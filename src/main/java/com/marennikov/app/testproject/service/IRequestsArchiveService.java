package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.RequestArchive;

import java.util.List;

public interface IRequestsArchiveService {

    RequestArchive saveRequestArchive(RequestArchive requestArchive);

    Iterable<RequestArchive> requestsArchiveListWithDelete();

    List<RequestArchive> requestArchiveList(String activeStatus);

    RequestArchive getById(Integer id);

    RequestArchive setDeleteStatus(RequestArchive requestArchive);

    RequestArchive getByRequesterIdWithLastVersion(Integer id);
}
