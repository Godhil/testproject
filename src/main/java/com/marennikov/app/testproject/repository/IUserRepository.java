package com.marennikov.app.testproject.repository;

import com.marennikov.app.testproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
