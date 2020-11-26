package com.codegym.controller;


import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping({"/","/product"})
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping({"","/list"})
    public String goList(Model model) {
        model.addAttribute("productList", productService.selectAllProduct());
        return "/list";
    }

    @GetMapping("/insert")
    public String goInsert(Model model) {
        model.addAttribute("product", new Product());
        return "/insert";
    }

    @PostMapping("/insert")
    public String insertProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.insertProduct(product);

        redirectAttributes.addFlashAttribute("message", "Create SuccessFully");
        return "redirect:/list";
    }

    @GetMapping("/{id}/update")
    public String goUpdate(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.selectProductById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.updateProduct(product);
        redirectAttributes.addFlashAttribute("message","Update SuccessFully");
        return "redirect:/list";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam int id, RedirectAttributes redirectAttributes) {
        productService.deleteProduct(id);
        redirectAttributes.addFlashAttribute("message","Delete SuccessFully");
        return "redirect:/list";
    }

    @GetMapping("/{id}/show")
    public String showProductByID(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.selectProductById(id));

        return "/view";
    }



}
