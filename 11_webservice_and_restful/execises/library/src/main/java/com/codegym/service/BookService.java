package com.codegym.service;

import com.codegym.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(Integer id);

    Page<Book> findAllHavePagination(Pageable pageable);

    boolean borrowBook(Integer id);

    void giveBack(Book book);

    void save(Book book);
}
