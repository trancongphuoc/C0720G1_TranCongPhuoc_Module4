package com.codegym.controller;


import com.codegym.entity.Blog;
import com.codegym.service.BlogService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping(value = {"/","/blog"})
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    CategoryService categoryService;

    @GetMapping({"","/home"})
    public String goHome(Model model,
                         @PageableDefault(size = 3)Pageable pageable,
                         @RequestParam Optional<Integer> categoryId,
                         @RequestParam Optional<String> title) {

        model.addAttribute("categoryList", categoryService.findAll());

        if (categoryId.isPresent()) {
            model.addAttribute("blogList",blogService.findAllByCategory(categoryId.get(), pageable));
            model.addAttribute("categoryId", categoryId.get());
        }else if (title.isPresent()) {
            model.addAttribute("blogList", blogService.findAllByTitle(title.get(), pageable));
            model.addAttribute("title", title.get());
        }else {
            model.addAttribute("blogList", blogService.findAll(pageable));
        }

        return "view/blog/home";
    }

    @GetMapping("/list")
    public String goList(Model model,
                         @PageableDefault(size = 3)Pageable pageable,
                         @RequestParam Optional<Integer> categoryId,
                         @RequestParam(defaultValue = "") Optional<String> title) {

        model.addAttribute("categoryList", categoryService.findAll());

        if (categoryId.isPresent()) {
            model.addAttribute("blogList",blogService.findAllByCategory(categoryId.get(), pageable));
            model.addAttribute("categoryId", categoryId.get());
        }else if (title.isPresent()) {
            model.addAttribute("blogList", blogService.findAllByTitle(title.get(), pageable));
            model.addAttribute("title", title.get());
        }else {
            model.addAttribute("blogList", blogService.findAll(pageable));
        }

        return "view/blog/list";
    }



    @GetMapping("/create")
    public String goCreate(Model model) {
        Blog blog = new Blog();

        blog.setDayWrite(LocalDate.now().toString());
        model.addAttribute("blog", blog);
        model.addAttribute("categoryList", categoryService.findAll());
        return "view/blog/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message","Create SuccessFully");

        return "redirect:/blog/list";
    }

    @GetMapping("/detail")
    public String goDetail(@RequestParam Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categoryList", categoryService.findAll());
        return "view/blog/detail";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete Successfully");

        return "redirect:/blog/list";
    }

    @GetMapping("/update")
    public String update(@RequestParam Integer id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        model.addAttribute("categoryList", categoryService.findAll());
        return "view/blog/update";
    }
}
