package com.codegym.service.impl;

import com.codegym.entity.Book;
import com.codegym.repository.BookRepository;
import com.codegym.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;


    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Book> findAllHavePagination(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public boolean borrowBook(Integer id) {
        if (findById(id).getAmount() == 0) {
            return false;
        } else {
            Book book = findById(id);
            book.setAmount(book.getAmount() - 1);
            save(book);
            return true;
        }
    }

    @Override
    public void giveBack(Book book) {
        book.setAmount(book.getAmount() + 1);
        save(book);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> findByCategory(Integer categoryId) {
        return bookRepository.findAllByCategory_Id(categoryId);
    }
}
