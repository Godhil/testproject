package com.marennikov.app.testproject.repository;

import com.marennikov.app.testproject.entity.Requests;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface IRequestsRepository extends JpaRepository<Requests, Integer> {
}
