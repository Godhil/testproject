package com.marennikov.app.testproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("test")
    public String test(){
        return "test";
    }

    @RequestMapping("municipality")
    public String municipality() {
        return "municipality";
    }

    @RequestMapping("user")
    public String user() {
        return "user/user";
    }

    @RequestMapping("userform")
    public String newUser(){
        return "user/newuser";
    }

    @RequestMapping("/user/edit/{id}")
    public String edit(@PathVariable Integer id){
        return "user/edituser";
    }

    @RequestMapping("adplace")
    public String adPlace() {
        return "adplace";
    }

    @RequestMapping("adconstruction")
    public String adConstruction() {
        return "adconstruction";
    }

    @RequestMapping("request")
    public String request() {
        return "request";
    }

    @RequestMapping("archive")
    public String requestArchive() {
        return "archive";
    }

    @RequestMapping("photo")
    public String photo() {
        return "photo";
    }
}
