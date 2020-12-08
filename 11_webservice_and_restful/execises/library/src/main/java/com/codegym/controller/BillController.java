package com.codegym.controller;


import com.codegym.entity.Bill;
import com.codegym.entity.BillDetail;
import com.codegym.entity.Book;
import com.codegym.entity.User;
import com.codegym.service.BillDetailService;
import com.codegym.service.BillService;
import com.codegym.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.*;

@Controller
@SessionAttributes({"user","tempBill"})
@RequestMapping("/bill")
public class BillController {

    @Autowired
    BillService billService;

    @Autowired
    BillDetailService billDetailService;

    @Autowired
    BookService bookService;

    // Xem Giỏ hàng
    @GetMapping("/tempBill")
    public String showTempBill() {
        return "view/bill/temp-bill";
    }


    // Danh sách Bill
    @GetMapping("/list")
    public String goBillList(@ModelAttribute User user, Model model) {
        // Nếu chưa có thông tin. phải đăng ký thông tin customer
        if (user.getCustomer() != null) {
            if (user.getCustomer().getId() == null) {
                return "redirect:/customer/";
            }
        } else {
            return "redirect:/customer/";
        }


        model.addAttribute("billList", billService.findAllByCustomer(user.getCustomer()));
        return "view/bill/list";
    }


    // Xem bill chi tiết.
    @GetMapping("/detail/{id}")
    public String goDetail(@PathVariable Integer id, Model model) {
        model.addAttribute("bill", billService.findById(id));
        return "view/bill/detail";
    }



    // Temp bill chi tiết
    @GetMapping("/go-pay")
    public String goPay(Model model,
                        @ModelAttribute("tempBill") List<Book> tempBill,
                        @ModelAttribute User user) {

        // Nếu user chưa có thông tin khách hàng
        if (user.getCustomer() == null) {
            return "redirect:/customer/";
        }

        Bill bill = new Bill();

        Integer codeBorrow;
        do {
            codeBorrow = new Random().nextInt(99999-10000) + 10000;
        } while(billService.findByCodeBorrow(codeBorrow) != null) ;

        String dayStartBorrow = LocalDate.now().toString();
        double totalMoney = 0.0;


        for (Book book: tempBill) {
            totalMoney += book.getRentCost();
        }

        bill.setCodeBorrow(codeBorrow);
        bill.setDayStartBorrow(dayStartBorrow);
        bill.setTotalMoney(totalMoney);

        model.addAttribute("bill", bill);
        return "view/bill/show-pay";
    }



    // Thanh toán
    @PostMapping("/pay")
    public String pay(@ModelAttribute("tempBill") List<Book> tempBill,
                      @ModelAttribute Bill bill,
                      HttpServletRequest request) {

        // Lưu vào bill
        for (Book book : tempBill) {
            BillDetail billDetail = new BillDetail();

            billDetail.setBook(bookService.findById(book.getId()));
            billDetail.setBill(bill);

            billDetailService.save(billDetail);
        }

        // Reset lại Giỏ hàng.
        tempBill.clear();

//        billService.save(bill);

        return "redirect:/library/list";
    }


    // Trả sách
    @GetMapping("/give-back/{id}")
    public String giveBack(@PathVariable Integer id) {
        Bill bill = billService.findById(id);

        for (BillDetail billDetail : bill.getBillDetailSet()) {
            bookService.giveBack(billDetail.getBook());
        }

        bill.setStatus(true);
        billService.save(bill);

        return "redirect:/bill/list";
    }


    // Trả sách bằng code-borrow
    @GetMapping("/code-borrow")
    public String goPay(@RequestParam Integer codeBorrow,
                        RedirectAttributes redirectAttributes,
                        @ModelAttribute User user,
                        Model model) {

        if (billService.findByCodeBorrowAndCustomer(codeBorrow,user.getCustomer()) == null) {
            redirectAttributes.addFlashAttribute("message", "Not find");
            return "redirect:/bill/list";
        } else {
            model.addAttribute("bill", billService.findByCodeBorrow(codeBorrow));
            return "view/bill/detail";
        }
    }


    @ExceptionHandler(Exception.class)
    public String catchException() {
        return "redirect:/login/";
    }
}
