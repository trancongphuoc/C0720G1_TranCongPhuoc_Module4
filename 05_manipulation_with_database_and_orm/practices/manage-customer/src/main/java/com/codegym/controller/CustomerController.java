package com.codegym.controller;

import com.codegym.entity.Customer;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"/customer", ""})
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
//    @GetMapping(value = "/")
    public String goListCustomer(Model model) {

        model.addAttribute("listCustomer", customerService.findAll());

        return "list_customer";
    }

    @GetMapping("/detail")
    public String goDetailStudent(@RequestParam Integer id, Model model) {
        model.addAttribute("customerDetail", customerService.findById(id));
        return "detail_customer";
    }

    @GetMapping("/detail/{idCustomer}")
    public String goDetailStudentPathVariable(@PathVariable(value = "idCustomer") Integer id, Model model) {
        model.addAttribute("customerDetail", customerService.findById(id));
        return "detail_customer";
    }

    @GetMapping("/create")
    public String goCreateStudent(Model model) {
        model.addAttribute("customer", new Customer());

        return "create_customer";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {

        this.customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Create customer OK!");

        return "redirect:/customer";
    }
}

