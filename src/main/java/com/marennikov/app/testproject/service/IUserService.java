package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.User;

import java.util.List;

public interface IUserService {

    User addUser(User user);

    User editUser(User user);

    Iterable<User> usersListWithDelete();

    User getById(Integer id);

    List<User> userList(String activeStatus);
}
