package com.codegym.controller;


import com.codegym.entity.User;
import com.codegym.repository.UserRepository;
import com.codegym.service.impl.CustomerServiceImpl;
import com.codegym.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@SessionAttributes("user")
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    CustomerServiceImpl customerService;


    // infor detail khách hàng
    @GetMapping("")
    public String goDetail(@ModelAttribute User user, Model model) {
        User user1 = userService.findByName(user.getUsername());
        model.addAttribute("user", user1);
        return "view/customer/detail";
    }


    // Lưu thông tin khách hàng
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute User user,
//                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

//        if (bindingResult.hasErrors()) {
//            return "view/customer/detail";
//        }

        customerService.save(user.getCustomer());

        redirectAttributes.addFlashAttribute("message","Save successfully");
        return "redirect:/customer/";
    }

//                  ^
    // Đổi pass word|
    @GetMapping("/change-password")
    public String goChangePassWord() {
        return "view/customer/change-password";
    }



    @ExceptionHandler(Exception.class)
    public String catchException() {
        return "redirect:/login/";
    }
}
