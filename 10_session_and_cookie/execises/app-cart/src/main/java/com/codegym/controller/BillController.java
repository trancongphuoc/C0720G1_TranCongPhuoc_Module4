package com.codegym.controller;

import com.codegym.entity.Bill;
import com.codegym.entity.Product;
import com.codegym.entity.User;
import com.codegym.service.BillService;
import com.codegym.service.UserService;
import com.codegym.service.impl.BillDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@SessionAttributes({"user", "cart"})
@RequestMapping("/bill")
public class BillController {

    @Autowired
    BillDetailServiceImpl billDetailService;

    @Autowired
    BillService billService;

    @Autowired
    UserService userService;

    @GetMapping("/pay")
    public String pay(
            @ModelAttribute User user,
            @ModelAttribute(name = "cart") ArrayList<Product> cart,
            HttpServletRequest request,
            RedirectAttributes redirectAttributes) {
        if (cart.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Cart is empty");
            return "redirect:/product/list";
        }

        billService.save(new Bill(),user, cart);

        cart.clear();
//        request.getSession().setAttribute("cart", null);
        return "redirect:/product/list";
    }

    @GetMapping("/list")
    public String goList(Model model, @RequestParam Optional<String> username) {
        User user = userService.findById(username.orElse(null));
        model.addAttribute("billList", billDetailService.findAllByUser(user));
        return "view/bill/list";
    }
}
