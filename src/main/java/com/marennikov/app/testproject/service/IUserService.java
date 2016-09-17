package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.User;

import java.util.List;

public interface IUserService {

    User saveUser(User user);

    Iterable<User> usersListWithDelete();

    User getById(Integer id);

    Iterable<User> userList(String activeStatus);

    User setDeleteStatus(User user);

    User getByLogin(String login);
}
