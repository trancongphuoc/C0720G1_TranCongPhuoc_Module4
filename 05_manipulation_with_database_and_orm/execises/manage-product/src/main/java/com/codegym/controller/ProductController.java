package com.codegym.controller;


import com.codegym.entity.Product;
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
    public String showListProduct(Model model) {
        model.addAttribute("productList", productService.findAllProduct());
        return "/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/create")
    public String createNewProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("message","Create Successfully");
        return "redirect:/list";
    }

    @GetMapping("/update/{id}")
    public String showFormUpdate(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.findProductById(id));
        return "/update";
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("message","Update Successfully");
        return "redirect:/list";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        productService.deleteProduct(id);
        redirectAttributes.addFlashAttribute("message", "Delete Successfully");
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    public String showDetailProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.findProductById(id));
        return "/detail";
    }


}
