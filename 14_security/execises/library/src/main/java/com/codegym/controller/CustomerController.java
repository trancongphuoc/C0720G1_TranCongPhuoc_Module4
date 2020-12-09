package com.codegym.controller;


import com.codegym.entity.AppUser;
import com.codegym.service.impl.CustomerServiceImpl;
import com.codegym.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String goDetail(@ModelAttribute AppUser appUser, Model model) {
        AppUser appUser1 = userService.findByName(appUser.getUsername());
        model.addAttribute("user", appUser1);
        return "view/customer/detail";
    }


    // Lưu thông tin khách hàng
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute AppUser appUser,
//                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

//        if (bindingResult.hasErrors()) {
//            return "view/customer/detail";
//        }

        customerService.save(appUser.getCustomer());

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
