package com.marennikov.app.testproject.repository;

import com.marennikov.app.testproject.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface IUsersRepository extends CrudRepository<Users, Integer> {
}
