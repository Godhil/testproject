package com.marennikov.app.testproject.service.impl;

import com.marennikov.app.testproject.entity.User;
import com.marennikov.app.testproject.repository.IUserRepository;
import com.marennikov.app.testproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    public void setUserRepository(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        User addUser = userRepository.saveAndFlush(user);

        return addUser;
    }

    @Override
    public User editUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public Iterable<User> usersListWithDelete() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> userList(String activeStatus) {
        return userRepository.findAllByActiveStatus(activeStatus);
    }

    @Override
    public User setDeleteStatus(User user) {
        user.setActiveStatus("Delete");
        return userRepository.saveAndFlush(user);
    }


}
