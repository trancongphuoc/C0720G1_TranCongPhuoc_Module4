package com.codegym.service.impl;

import com.codegym.entity.Blog;
import com.codegym.entity.Category;
import com.codegym.repository.BlogRepository;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Blog> findAllByTitle(String keyWord, Pageable pageable) {
        return blogRepository.findByTitleContaining(keyWord, pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(Integer id) {
        blogRepository.delete(blogRepository.findById(id).orElseGet(null));
    }

    @Override
    public Page<Blog> findAllByCategory(Integer categoryId, Pageable pageable) {
        return blogRepository.findAllByCategory_Id(categoryId, pageable);
    }
}
