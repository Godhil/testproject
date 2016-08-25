package com.marennikov.app.testproject.repository;

import com.marennikov.app.testproject.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsersRepository extends JpaRepository<Users, Integer> {
}
