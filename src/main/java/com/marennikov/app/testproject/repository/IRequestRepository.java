package com.marennikov.app.testproject.repository;

import com.marennikov.app.testproject.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRequestRepository extends JpaRepository<Request, Integer> {

    List<Request> findAllByActiveStatus(String activeStatus);
    
    List<Request> findAllByRequesterIdAndStatusNotLike(Integer id, String status);

    List<Request> findAllByStatus(Integer id, String status);

    List<Request> findAllByStatus(String status);

    Request findOneByAdPlaceId(Integer id);

    Request findOneByAdConstructionId(Integer id);
}
