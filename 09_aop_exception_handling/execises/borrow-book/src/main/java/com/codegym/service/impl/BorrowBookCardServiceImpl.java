package com.codegym.service.impl;

import com.codegym.entity.Book;
import com.codegym.entity.BorrowBookCard;
import com.codegym.entity.Member;
import com.codegym.repository.BorrowBookCardRepository;
import com.codegym.service.BookService;
import com.codegym.service.BorrowBookCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowBookCardServiceImpl implements BorrowBookCardService {

    @Autowired
    BorrowBookCardRepository borrowBookCardRepository;

    @Autowired
    BookService bookService;

    @Override
    public List<BorrowBookCard> findAll() {
        return borrowBookCardRepository.findAll();
    }

    @Override
    public void save(BorrowBookCard borrowBookCard, Book book, Member member) {
        borrowBookCard.setDayStartBorrow(LocalDate.now().toString());
        borrowBookCard.setMember(member);
        borrowBookCard.setBook(book);

        book.setAmount(book.getAmount() - 1);
        bookService.save(book);
        borrowBookCardRepository.save(borrowBookCard);

    }

    @Override
    public BorrowBookCard findById(Integer id) {
        return borrowBookCardRepository.findById(id).orElse(null);
    }

    @Override
    public void update(BorrowBookCard borrowBookCard) {
        borrowBookCard.setStatus(true);
        borrowBookCard.setDayEndBorrow(LocalDate.now().toString());
        borrowBookCardRepository.save(borrowBookCard);

        Book book = borrowBookCard.getBook();
        book.setAmount(book.getAmount() + 1);
        bookService.save(book);
    }
}
