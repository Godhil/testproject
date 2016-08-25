package com.marennikov.app.testproject.service.impl;

import com.marennikov.app.testproject.entity.Users;
import com.marennikov.app.testproject.repository.IUsersRepository;
import com.marennikov.app.testproject.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersImpl implements IUsersService {

    private IUsersRepository usersRepository;

    @Autowired
    public void setUsersRepository(IUsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Iterable<Users> usersList() {
        return usersRepository.findAll();
    }

    @Override
    public Users getUserById(Integer id) {
        return usersRepository.findOne(id);
    }

    @Override
    public Users saveUser(Users user) {
        return usersRepository.save(user);
    }
}
