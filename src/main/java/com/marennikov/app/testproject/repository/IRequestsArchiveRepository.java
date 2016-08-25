package com.marennikov.app.testproject.repository;

import com.marennikov.app.testproject.entity.RequestsArchive;
import org.springframework.data.repository.CrudRepository;

public interface IRequestsArchiveRepository extends CrudRepository<RequestsArchive, Integer> {
}
