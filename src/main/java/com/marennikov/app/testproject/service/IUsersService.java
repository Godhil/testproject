package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.Users;

public interface IUsersService {

    Iterable<Users> usersList();

    Users getUserById(Integer id);

    Users saveUser(Users user);

}
