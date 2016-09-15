package com.marennikov.app.testproject.repository;

import com.marennikov.app.testproject.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRequestRepository extends JpaRepository<Request, Integer> {

    List<Request> findAllByActiveStatus(String activeStatus);
    
    Iterable<Request> findAllByRequesterIdAndStatusNotLike(Integer id, String status);

    Iterable<Request> findAllByRequesterIdAndStatus(Integer id, String status);

    Iterable<Request> findAllByStatus(String status);

    Request findOneByAdPlaceId(Integer id);

    Request findOneByAdConstructionId(Integer id);
}
