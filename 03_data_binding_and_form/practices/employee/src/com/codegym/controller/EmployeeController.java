package com.codegym.controller;


import com.codegym.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {


    @RequestMapping(value = "show-form", method = RequestMethod.GET)
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());

        return "show-form";
    }


    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String submit(@ModelAttribute("employee") Employee employee, Model model) {
        model.addAttribute("employee", employee);

        return "info";
    }


}
