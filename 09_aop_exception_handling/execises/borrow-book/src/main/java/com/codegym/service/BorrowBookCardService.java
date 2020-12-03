package com.codegym.service;

import com.codegym.entity.Book;
import com.codegym.entity.BorrowBookCard;
import com.codegym.entity.Member;

import java.util.List;

public interface BorrowBookCardService {

    List<BorrowBookCard> findAll();

    BorrowBookCard save(BorrowBookCard borrowBookCard, Book book, Member member);

    BorrowBookCard findById(Integer id);
}
