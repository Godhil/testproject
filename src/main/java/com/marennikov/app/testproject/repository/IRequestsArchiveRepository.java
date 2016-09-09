package com.marennikov.app.testproject.repository;

import com.marennikov.app.testproject.entity.RequestArchive;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRequestsArchiveRepository extends JpaRepository<RequestArchive, Integer> {


    List<RequestArchive> findAllByActiveStatus(String activeStatus);
}
