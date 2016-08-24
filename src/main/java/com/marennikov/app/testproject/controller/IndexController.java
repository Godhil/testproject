package com.marennikov.app.testproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/testproject")
    public String index() {
        return "index";
    }
}
