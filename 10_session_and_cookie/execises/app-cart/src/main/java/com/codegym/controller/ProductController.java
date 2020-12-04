package com.codegym.controller;


import com.codegym.entity.Product;
import com.codegym.entity.User;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes({"user","sessionDetail","cart"})
@RequestMapping({"/product"})
public class ProductController {

    @ModelAttribute("cart")
    public List<Product> setUpCart() {
        return new ArrayList<>();
    }

    @Autowired
    ProductService productService;

    @GetMapping("/list")
    public String goList(Model model) {
        model.addAttribute("productList", productService.findAll());
        model.addAttribute("cart", new ArrayList<Product>());
        return "view/product/list";
    }

//    List<Product> cart = new ArrayList<>();
    @GetMapping("/add-product")
    public String addProduct(@RequestParam Integer id,
                             Model model,
                             RedirectAttributes redirectAttributes,
                             @ModelAttribute ArrayList<Product> cart) {

        if (productService.findById(id).getAmount() == 0) {
            redirectAttributes.addFlashAttribute("message", "It's over");
            return "redirect:/product/list";
        }

        cart.add(productService.findById(id));

        Product product = productService.findById(id);
        product.setAmount(product.getAmount() - 1);
        productService.save(product);

        return "redirect:/product/list";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam Integer id, Model model) {

        model.addAttribute("product", productService.findById(id));
        model.addAttribute("productList", new ArrayList<>());
//        if (user == null) {
//            user = null;
//            model.addAttribute("sessionDetail", id);
//            return "view/product/detail";
//        }
        return "view/product/detail";
    }

    @GetMapping("/cart")
    public String goCart(Model model, @ModelAttribute User user, @ModelAttribute ArrayList<Product> cart) {
        if (user.getUsername() == null) {
            return "redirect:/home/login";
        }
//        model.addAttribute("productList", cart);
         Integer[] arr = new Integer[cart.size()];
        for (int i = 0; i < cart.size(); i++) {
            arr[i] = cart.get(i).getId();
        }
        model.addAttribute("arr", arr);
        return "view/product/cart";
    }

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam Integer index,
                                @RequestParam Integer idProduct,
                                Model model,
                                @ModelAttribute ArrayList<Product> cart) {
        cart.remove(index-1);

        Product product = productService.findById(idProduct);
        product.setAmount(product.getAmount() + 1);
        productService.save(product);

        return "redirect:/product/cart";
    }
}
