package com.codegym.controller;


import com.codegym.entity.Book;
import com.codegym.entity.AppUser;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("tempBill")
@RequestMapping({"/login"})
public class LoginController {


    @Autowired
    UserService userService;


    // Màn hình đăng nhập
    @GetMapping("")
    public String goFormSignIn(Model model) {
        model.addAttribute("user", new AppUser());
        return "/view/login/sign-in";
    }



    // Màn hình đăng ký.
    @GetMapping("/register")
    public ModelAndView goSignUp() {
        return new ModelAndView("/view/login/sign-up","appUser",new AppUser());
    }



    // Đăng ký.
    @PostMapping("/sign-up")
    public String signUp(@ModelAttribute AppUser appUser,
                         RedirectAttributes redirectAttributes,
                         @RequestParam Optional<String> checkbox) {
        // Check i'm not robot
        if (checkbox.orElse(null) == null) {
            redirectAttributes.addFlashAttribute("errorCheckbox","Click me!!!");
            return "redirect:/login/register";
        }


        if (!userService.save(appUser)) {
            redirectAttributes.addFlashAttribute("errorUser","AppUser is exist");
            return "redirect:/login/register";
        } else {
//            redirectAttributes.addFlashAttribute("user", appUser);
            redirectAttributes.addFlashAttribute("message","Welcome" + appUser.getUsername());
            return "redirect:/library/list";
        }

    }


//    // Đăng xuất
//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request, @ModelAttribute(name = "tempBill") List<Book> tempBill) {
//        tempBill.clear();
//        return "redirect:/home/";
//    }

}
