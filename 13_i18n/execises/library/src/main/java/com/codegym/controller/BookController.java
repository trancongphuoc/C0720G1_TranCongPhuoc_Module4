package com.codegym.controller;

import com.codegym.entity.Book;
import com.codegym.service.BookService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"user","tempBill"})
@RequestMapping("/library")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    CategoryService categoryService;


    // Tạo session tempBill
    @ModelAttribute("tempBill")
    public List<Book> takeBook() {
        return new ArrayList<>();
    }


    // Hiển thị danh sách book
    @GetMapping({"","/list"})
    public ModelAndView goList(@PageableDefault(size = 3) Pageable pageable) {
        return new ModelAndView("view/book/list","bookList",bookService.findAllHavePagination(pageable));
    }


    // Xem chi tiết book
    @GetMapping("/detail/{id}")
    public ModelAndView goDetail(@PathVariable Integer id) {
        return new ModelAndView("view/book/detail","book",bookService.findById(id));
    }


    // Action: Mượn sách
    @GetMapping("/borrow/{id}")
    public String borrowBook(@PathVariable Integer id,
                             @ModelAttribute("tempBill") List<Book> tempBill,
                             RedirectAttributes redirectAttributes) {

        if (!bookService.borrowBook(id)) {
            redirectAttributes.addFlashAttribute("message","It's over");
        } else {
            tempBill.add(bookService.findById(id));
        }
        return "redirect:/library/list";
    }


    // Action: Trả sách
    @GetMapping("/delete/{index}")
    public String removedBookInTempBill(@PathVariable int index,
                                        @ModelAttribute("tempBill") List<Book> tempBill) {

        bookService.giveBack(tempBill.remove(index));

        return "redirect:/bill/tempBill";
    }



    // Thêm sách vào thư viện
    @GetMapping("/create")
    public String goCreateNewBook(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("categoryList", categoryService.findAll());
        return "view/book/create";
    }


    @PostMapping("/create")
    public String createNewBook(@Valid @ModelAttribute Book book,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes,
                                Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("categoryList", categoryService.findAll());
            return "view/book/create";
        }
        bookService.save(book);
        redirectAttributes.addFlashAttribute("message","register successfully");
        return "redirect:/library/list";
    }

}
