package com.marennikov.app.testproject.controller;

import com.marennikov.app.testproject.entity.Users;
import com.marennikov.app.testproject.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    private IUsersService usersService;

    @Autowired
    public void setUsersService(IUsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Iterable<Users> getUsersList(){
        return usersService.usersList();
    }


}
