package com.codegym.controller;


import com.codegym.entity.User;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@SessionAttributes({"sessionDetail"})
@RequestMapping("/home")
public class LoginController {

    @Autowired
    UserService userService;


    @GetMapping("/login")
    public String goLogin(Model model , @ModelAttribute User user) {
        if (user.getUsername() != null) {
            return "redirect:/product/list";
        }
        model.addAttribute("user", new User());
        return "view/user/login";
    }

    @PostMapping("/login")
    public String checkLogin(@ModelAttribute User user,
                             RedirectAttributes redirectAttributes,
                             @RequestParam Optional<String> sessionDetail) {
        User userTest = userService.findById(user.getUsername());

        if (userTest == null) {
            redirectAttributes.addFlashAttribute("errorUsername","User does not exist");
            return "redirect:/home/login";
        } else if (user.getPassword().equals(userTest.getPassword())) {
            redirectAttributes.addFlashAttribute("user", user);
            if (sessionDetail.orElse(null) != null) {
                return "redirect:/product/detail?id="+sessionDetail.get();
            }
            return "redirect:/product/list";
        } else {
            redirectAttributes.addFlashAttribute("errorPassword","Wrong password");
            return "redirect:/home/login";
        }

    }


    @GetMapping("/logout")
    public String logout(Model model, HttpServletRequest request) {
        request.getSession().setAttribute("user", null);
        return "view/home";
    }
}
