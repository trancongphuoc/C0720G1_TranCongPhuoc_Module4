package com.codegym.controller;


import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
@RequestMapping({"/","/home"})
public class HomeController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public String goHome(Model model) {
        return "view/home";
    }
}
