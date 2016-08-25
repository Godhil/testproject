package com.marennikov.app.testproject.repository;

import com.marennikov.app.testproject.entity.Requests;
import org.springframework.data.repository.CrudRepository;

public interface IRequestsRepository extends CrudRepository<Requests, Integer> {
}
