package com.codegym.controller;


import com.codegym.entity.Book;
import com.codegym.entity.User;
import com.codegym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
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

    private static Cookie cookieUsername;
    private static Cookie cookiePassword;


    public static Cookie getCookieUsername() {
        return cookieUsername;
    }

    public static Cookie getCookiePassword() {
        return cookiePassword;
    }

    @Autowired
    UserService userService;


    // Màn hình đăng nhập
    @GetMapping("")
    public String goFormSignIn(Model model) {
        model.addAttribute("user", new User());
        return "/view/login/sign-in";
    }


    // Đăng nhập
    @PostMapping("/sign-in")
    public String signIn(@ModelAttribute User user,
                         RedirectAttributes redirectAttributes,
                         @RequestParam Optional<String> checkbox,
                         HttpServletResponse response){

        User getUser = userService.findByName(user.getUsername());

        if (getUser == null) {
            redirectAttributes.addFlashAttribute("errorUser","User does not exist...");
            return "redirect:/login/";
        } else if (!getUser.getPassword().equals(user.getPassword())) {
            redirectAttributes.addFlashAttribute("errorPassword","Wrong password...");
            return "redirect:/login/";
        } else {
            if (checkbox.orElse(null) != null) {
                cookieUsername = new Cookie("cookieUsername", user.getUsername());
                cookieUsername.setMaxAge(60);
                cookiePassword = new Cookie("cookiePassword", user.getPassword());
                cookiePassword.setMaxAge(60);

                response.addCookie(cookieUsername);
                response.addCookie(cookiePassword);
            }
            redirectAttributes.addFlashAttribute("user", getUser);
            return "redirect:/library/list";
        }

    }


    // Màn hình đăng ký.
    @GetMapping("/register")
    public ModelAndView goSignUp() {
        return new ModelAndView("/view/login/sign-up","user",new User());
    }



    // Đăng ký.
    @PostMapping("/sign-up")
    public String signUp(@ModelAttribute User user,
                         RedirectAttributes redirectAttributes,
                         @RequestParam Optional<String> checkbox) {
        // Check i'm not robot
        if (checkbox.orElse(null) == null) {
            redirectAttributes.addFlashAttribute("errorCheckbox","Click me!!!");
            return "redirect:/login/register";
        }


        if (!userService.save(user)) {
            redirectAttributes.addFlashAttribute("errorUser","User is exist");
            return "redirect:/login/register";
        } else {
            redirectAttributes.addFlashAttribute("user", user);
            redirectAttributes.addFlashAttribute("message","Welcome" + user.getUsername());
            return "redirect:/library/list";
        }

    }


    // Đăng xuất
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, @ModelAttribute(name = "tempBill") List<Book> tempBill) {
        request.getSession().setAttribute("user", null);
        cookieUsername = null;
        cookiePassword = null;

        tempBill.clear();
        return "redirect:/home/";
    }

//    @ExceptionHandler(Exception.class)
//    public String catchException() {
//        return "redirect:/login/";
//    }
}
