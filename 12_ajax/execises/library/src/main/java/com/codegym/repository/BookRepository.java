package com.codegym.repository;

import com.codegym.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllByCategory_Id(Integer categoryId);



    List<Book> findAllByNameContaining(String name);
}
