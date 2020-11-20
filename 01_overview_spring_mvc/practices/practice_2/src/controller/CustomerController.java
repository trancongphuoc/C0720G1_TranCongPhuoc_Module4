package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CustomerService;


@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping({"/customers",""})
    public String showListCustomer(Model model) {

        model.addAttribute("customerList", customerService.findAllCustomer());

        return "customers/list";
    }

    @GetMapping("/find")
    public String showCustomerById(@RequestParam String id, Model model) {

        model.addAttribute("customer", customerService.findCustomerById(Integer.parseInt(id)));

        return "customers/customer";
    }


}
