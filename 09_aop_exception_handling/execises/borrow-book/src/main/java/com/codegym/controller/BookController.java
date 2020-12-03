package com.codegym.controller;


import com.codegym.entity.Book;
import com.codegym.service.BookService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    CategoryService categoryService;


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

    @GetMapping(value = "/create")
    public String showCreateBook(Model model) {
        model.addAttribute("book",new Book());
        model.addAttribute("categoryList", categoryService.findAll());
        return "view/book/create";
    }

    @PostMapping(value = "/create")
    public String createBook(@ModelAttribute Book book, RedirectAttributes redirectAttributes) {
        bookService.save(book);
        redirectAttributes.addFlashAttribute("message","Create successfully");
        return "redirect:/book/manage";
    }

}
