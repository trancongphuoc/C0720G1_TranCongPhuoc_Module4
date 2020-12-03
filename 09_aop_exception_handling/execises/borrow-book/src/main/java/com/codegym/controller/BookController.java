package com.codegym.controller;


import com.codegym.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    BookService bookService;


    @GetMapping(value = "/manage")
    public String goManage(Model model, @RequestParam Optional<Integer> idMember) {
        model.addAttribute("bookList", bookService.findAll());
        model.addAttribute("idMember", idMember.orElse(null));

        return "view/book/manage";
    }

    @GetMapping(value = "/detail")
    public String goDetail(@RequestParam Optional<Integer> idMember,
                           @RequestParam Integer idBook,
                           Model model) {
        model.addAttribute("book", bookService.findById(idBook));
        model.addAttribute("idMember", idMember.orElse(null));

        return "view/book/detail";
    }


}
