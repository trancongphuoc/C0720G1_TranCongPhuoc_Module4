package com.codegym.service;

import com.codegym.entity.Blog;

import java.util.List;

public interface BlogService {

    List<Blog> findAllBlog();

    void saveBlog(Blog blog);

    Blog findALlBlogById(Integer id);

    void deleteBlog(Integer id);
}
