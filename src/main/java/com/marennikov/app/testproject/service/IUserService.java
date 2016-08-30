package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.User;

public interface IUserService {

    User addUser(User user);

    void delete(Integer id);

    User editUser(User user);

    Iterable<User> usersList();

}
