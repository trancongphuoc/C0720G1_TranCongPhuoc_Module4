package com.codegym.controller;


import com.codegym.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value = {"/","/user"})
public class UserController {

    @GetMapping("/sign-up")
    public String goFormRegisterAccount(Model model) {
        model.addAttribute("user", new User());

        return "view/user/sign_up";
    }

    @PostMapping("/sign-up")
    public String signUpUser(@Valid @ModelAttribute User user,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        System.out.println(user.getDateOfBirth());
        new User().validate(user, bindingResult);

        if (bindingResult.hasErrors()) {
            return "view/user/sign_up";
        }

        redirectAttributes.addFlashAttribute("message", "Register successfully");

        return "redirect:/sign-up";

    }

}
