package com.codegym.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    @GetMapping("/save")
    public String goOrderSandwich(@RequestParam String[] condiment, Model model) {

        model.addAttribute("condiment", condiment);

        return "order";
    }
}
