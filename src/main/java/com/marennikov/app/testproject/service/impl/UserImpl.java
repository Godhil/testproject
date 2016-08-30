package com.marennikov.app.testproject.service.impl;

import com.marennikov.app.testproject.entity.User;
import com.marennikov.app.testproject.repository.IUserRepository;
import com.marennikov.app.testproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void delete(Integer id) {
        userRepository.delete(id);
    }

    @Override
    public User editUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public Iterable<User> usersList() {
        return userRepository.findAll();
    }
}
