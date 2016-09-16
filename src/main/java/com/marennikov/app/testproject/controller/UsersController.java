package com.marennikov.app.testproject.controller;

import com.marennikov.app.testproject.entity.User;
import com.marennikov.app.testproject.service.IMunicipalityService;
import com.marennikov.app.testproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UsersController {

    private IUserService userService;

    private IMunicipalityService municipalityService;

    @Autowired
    public void setUserService(IUserService userService){
        this.userService = userService;
    }

    @Autowired
    public void setMunicipalityService(IMunicipalityService municipalityService) {
        this.municipalityService = municipalityService;
    }

    //список пользователей, без отключенных
    @RequestMapping("users")
    public String usersListWithOutDelete(Model model) {
        model.addAttribute("userList", userService.userList(null));
        return "user/users";
    }

    //сохранение
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String saveUser(User user){
        if (user.getId() == null){
            String pwd;
            pwd = hash(user.getPassword());
            user.setPassword(pwd);
        }
        userService.saveUser(user);
        return "redirect:/user/users";
    }

    //Новый пользователь
    @RequestMapping(value = "user")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("municipalityList", municipalityService.municipalityList(null));
        return "user/user";
    }

    //Редактирование пользователя
    @RequestMapping(value = "user/{id}")
    public String editUser(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getById(id));
        model.addAttribute("municipalityList", municipalityService.municipalityList(null));
        return "user/user";
    }

    //отключение(установить флаг "Delete")
    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.POST)
    public String setDelete(@PathVariable Integer id){
        User user = userService.getById(id);
        userService.setDeleteStatus(user);
        return "redirect:/user/users";
    }

    private String hash(String str) {
        int result = str.hashCode();
        return String.valueOf(result);
    }

}