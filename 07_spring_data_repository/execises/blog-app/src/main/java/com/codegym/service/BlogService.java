package com.codegym.service;

import com.codegym.entity.Blog;
import com.codegym.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {

    Page<Blog> findAll(Pageable pageable);

    Blog findById(Integer id);

    Page<Blog> findAllByTitle(String keyWord, Pageable pageable);

    void save(Blog blog);

    void delete(Integer id);

    Page<Blog> findAllByCategory(Integer categoryId, Pageable pageable);



}
