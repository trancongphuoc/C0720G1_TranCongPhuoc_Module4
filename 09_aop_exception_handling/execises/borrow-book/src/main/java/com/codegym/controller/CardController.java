package com.codegym.controller;

import com.codegym.entity.BorrowBookCard;
import com.codegym.service.BookService;
import com.codegym.service.BorrowBookCardService;
import com.codegym.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/card")
public class CardController {


    @Autowired
    BorrowBookCardService borrowBookCardService;

    @Autowired
    BookService bookService;

    @Autowired
    MemberService memberService;

    @GetMapping(value = "/manage")
    public String goManage(Model model) {
        model.addAttribute("cardList", borrowBookCardService.findAll());

        return "view/card/manage";
    }


    @GetMapping(value = "/borrow")
    public String borrowBook(@RequestParam Integer idMember,
                             @RequestParam Integer idBook,
                             RedirectAttributes redirectAttributes) {

        if (bookService.findById(idBook).getAmount() == 0) {
            redirectAttributes.addFlashAttribute("message", "It's over");
            return "redirect:/book/manage";
        }

        borrowBookCardService.save(new BorrowBookCard(), bookService.findById(idBook), memberService.findById(idMember));

        redirectAttributes.addFlashAttribute("idMember1", idMember);

        return "redirect:/book/manage";
    }

    @GetMapping(value = "/give-back")
    public String giveBackBook(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        if (borrowBookCardService.findById(id).getStatus()) {
            redirectAttributes.addFlashAttribute("message", "Give back Failed");
            return "redirect:/card/manage";
        }
        borrowBookCardService.update(borrowBookCardService.findById(id));
        redirectAttributes.addFlashAttribute("message","Give back successfully");
        return "redirect:/card/manage";
    }



}
