package com.marennikov.app.testproject.repository;

import com.marennikov.app.testproject.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRequestRepository extends JpaRepository<Request, Integer> {
}
