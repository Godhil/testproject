package com.marennikov.app.testproject.controller;

import com.marennikov.app.testproject.entity.User;
import com.marennikov.app.testproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {

    private IUserService usersService;

    @Autowired
    public void setUsersService(IUserService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Iterable<User> getUsersList(){
        return usersService.usersList();
    }

    @RequestMapping(value = "/deluser/{id}", method = RequestMethod.GET)
    public void delete(@PathVariable Integer id) {
        usersService.delete(id);
    }




}
