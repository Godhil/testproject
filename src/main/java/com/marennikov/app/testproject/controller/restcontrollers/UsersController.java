package com.marennikov.app.testproject.controller.restcontrollers;

import com.marennikov.app.testproject.entity.User;
import com.marennikov.app.testproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api")
public class UsersController {

    private IUserService userService;

    @Autowired
    public void setUserService(IUserService userService){
        this.userService = userService;
    }

    @RequestMapping("userListWithDelete")
    @ResponseBody
    public Iterable<User> usersListWithDelete() {
        return userService.usersListWithDelete();
    }

    @RequestMapping("userList")
    @ResponseBody
    public List<User> userList(String activeStatus) {
        return userService.userList(activeStatus);
    }

    @RequestMapping(value="user", method=RequestMethod.POST)
    @ResponseBody
    public String addUser(User user) {
        userService.addUser(user);
        return "Saved User: " + user.toString();
    }

    @RequestMapping(value="user/edit", method=RequestMethod.POST)
    @ResponseBody
    public String editUser(User user) {
        userService.editUser(user);
        return "Saved User: " + user.toString();
    }

    @RequestMapping("user/{id}")
    @ResponseBody
    public User getUserById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @RequestMapping("user/delete/{id}")
    @ResponseBody
    public void deleteById(@PathVariable Integer id) {
        userService.delete(id);
    }
}