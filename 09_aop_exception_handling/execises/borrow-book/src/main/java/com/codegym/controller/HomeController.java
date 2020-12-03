package com.codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/home","/"})
public class HomeController {

    @GetMapping(value = "")
    public String goHome() {
        return "view/home";
    }
}
