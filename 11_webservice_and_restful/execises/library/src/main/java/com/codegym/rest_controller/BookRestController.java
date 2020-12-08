package com.codegym.rest_controller;


import com.codegym.entity.Book;
import com.codegym.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api-book")
public class BookRestController {

    @Autowired
    BookService bookService;

//    @GetMapping("/list")
//    public ResponseEntity<List<Book>> returnList() {
//        List<Book> bookList = bookService.findAll();
//
//        if (bookList.size() == 0) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(bookList,HttpStatus.OK);
//    }

    @GetMapping("/list")
    public ResponseEntity<List<Book>> returnList(@PageableDefault(size = 3) Pageable pageable) {
        Page<Book> bookList = bookService.findAllHavePagination(pageable);

        if (bookList.toList().size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookList.toList(),HttpStatus.OK);
    }


    @GetMapping("/find-by-name/{name}")
    public ResponseEntity<List<Book>> findByName(@PathVariable String name) {
        List<Book> bookList= bookService.findAllByName(name);

        if (bookList.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookList,HttpStatus.OK);
    }


    @GetMapping("/detail/{id}")
    public ResponseEntity<Book> bookDetail(@PathVariable Integer id) {
        Book book = bookService.findById(id);

        if (book == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("list-by-category/{idCategory}")
    public ResponseEntity<List<Book>> findByCategory(@PathVariable Integer idCategory) {
        if (bookService.findByCategory(idCategory).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookService.findByCategory(idCategory),HttpStatus.OK);
    }


}
