package com.marennikov.app.testproject.repository;

import com.marennikov.app.testproject.entity.RequestsArchive;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRequestsArchiveRepository extends JpaRepository<RequestsArchive, Integer> {
}
