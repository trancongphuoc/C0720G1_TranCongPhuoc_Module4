package com.codegym.controller;

import com.codegym.service.service.ServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/service"})
public class ServiceController {

    @Autowired
    private ServiceDao serviceDao;

    @GetMapping({"","/list"})
    public String goList(@PageableDefault(size = 3)Pageable pageable, Model model) {
        model.addAttribute("serviceList", serviceDao.findAll(pageable));
        return "view/service/list";
    }

    @GetMapping("/detail/{id}")
    public String goDetail(@PathVariable Long id,Model model) {

//        -----------------
        if (serviceDao.findById(id) == null) {
            return "404";
        }

        model.addAttribute("service", serviceDao.findById(id));
        return "view/service/detail";
    }



}
