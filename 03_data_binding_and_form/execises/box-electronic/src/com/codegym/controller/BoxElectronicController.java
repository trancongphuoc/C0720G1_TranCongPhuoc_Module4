package com.codegym.controller;

import com.codegym.model.BoxElectronic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = {"/box-electronic",""})
@Controller
public class BoxElectronicController {

    @GetMapping({"/create","/"})
    public String goCreate(Model model) {
        model.addAttribute("boxElectronic", new BoxElectronicController());

        return "create_box_electronic";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute BoxElectronic boxElectronic, Model model) {

        model.addAttribute("boxElectronic", boxElectronic);
        return "show";
    }


}
