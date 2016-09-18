package com.marennikov.app.testproject.service;

import com.marennikov.app.testproject.entity.User;

import java.util.List;

public interface IUserService {

    User saveUser(User user);

    List<User> usersListWithDelete();

    User getById(Integer id);

    List<User> userList(String activeStatus);

    User setDeleteStatus(User user);

    User getByLogin(String login);
}
