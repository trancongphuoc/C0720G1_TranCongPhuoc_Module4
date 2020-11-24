package com.codegym.controller;

import com.codegym.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculateController {

    @Autowired
    CalculateService calculateService;

    @GetMapping({"/calculate",""})
    public String goCalculate(@RequestParam String firstNumber,
                              @RequestParam String secondNumber,
                              @RequestParam String calculation,
                              Model model) {

        double firstNumberInt;
        double secondNumberInt;

        try {
            firstNumberInt = Double.parseDouble(firstNumber);
            secondNumberInt = Double.parseDouble(secondNumber);
        } catch (NumberFormatException e) {
            model.addAttribute("message", "NumberFormat Exception");
            return "index";
        }

        double result = calculateService.calculate(firstNumberInt, secondNumberInt, calculation);

        model.addAttribute("result", result);

        return "index";
    }
}
