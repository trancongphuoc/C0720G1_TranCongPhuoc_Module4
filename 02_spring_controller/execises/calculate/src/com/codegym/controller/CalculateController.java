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

        int firstNumberInt;
        int secondNumberInt;

        try {
            firstNumberInt = Integer.parseInt(firstNumber);
            secondNumberInt = Integer.parseInt(secondNumber);
        } catch (NumberFormatException e) {
            model.addAttribute("message", "NumberFormat Exception");
            return "index";
        }

        double result = 0;

        switch (calculation) {
            case "+":
                result = calculateService.addition(firstNumberInt,secondNumberInt);
                break;
            case "-":
                result = calculateService.subtraction(firstNumberInt,secondNumberInt);
                break;
            case "x":
                result = calculateService.multiplication(firstNumberInt,secondNumberInt);
                break;
            case "/":
                result = calculateService.division(firstNumberInt,secondNumberInt);
                break;
        }

        model.addAttribute("result", result);

        return "index";
    }
}
