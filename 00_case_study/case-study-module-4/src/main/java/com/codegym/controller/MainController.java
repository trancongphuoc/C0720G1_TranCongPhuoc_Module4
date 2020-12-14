package com.codegym.controller;

import com.codegym.entity.user.User;
import com.codegym.service.user.UserService;
import com.codegym.validatior.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @Autowired
    private UserValidator userValidator;


    @GetMapping(value = {"/","/home"})
    public String goHome() {
        return "view/home";
    }

    @GetMapping("/sign-in")
    public String goSignIn() {
        return "view/user/sign-in";
    }

    @GetMapping("/sign-up")
    public String goSignUp(Model model) {
        model.addAttribute("user", new User());
        return "view/user/sign-up";
    }

    @PostMapping("/sign-up")
    public String signUp(@Valid @ModelAttribute User user,
                         BindingResult bindingResult) {

        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "view/user/sign-up";
        }

        userService.registerNewUser(user);

        return "redirect:/home";
    }




}
