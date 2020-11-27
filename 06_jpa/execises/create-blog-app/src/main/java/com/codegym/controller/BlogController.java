package com.codegym.controller;

import com.codegym.entity.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = {"/","/blog"})
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping(value = {"","/list"})
    public String showBlogList(Model model){
        model.addAttribute("blogList", blogService.findAllBlog());
        return "blog/list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detailBlog(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", blogService.findALlBlogById(id));

        return "blog/detail";
    }

    @GetMapping(value = "/create")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());

        return "blog/create";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.saveBlog(blog);

        redirectAttributes.addFlashAttribute("message","register successfully");

        return "redirect:/manage";
    }

    @GetMapping(value = "/manage")
    public String manage(Model model) {
        model.addAttribute("blogList", blogService.findAllBlog());
        return "blog/manage";
    }

    @GetMapping(value = "/update/{id}")
    public String showFormUpdate(@PathVariable Integer id, Model model) {
        model.addAttribute("blog",blogService.findALlBlogById(id));
        return "blog/update";
    }


    @PostMapping(value = "/update")
    public String updateBlog(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.saveBlog(blog);

        redirectAttributes.addFlashAttribute("message","update successfully");

        return "redirect:/manage";
    }

    @PostMapping(value = "/delete")
    public String deleteBlog(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        blogService.deleteBlog(id);
        redirectAttributes.addFlashAttribute("message","Delete successfully");

        return "redirect:/manage";
    }

}
