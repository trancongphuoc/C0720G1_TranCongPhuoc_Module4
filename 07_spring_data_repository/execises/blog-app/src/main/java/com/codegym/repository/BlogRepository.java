package com.codegym.repository;

import com.codegym.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

    Page<Blog>findByTitleContaining(String keyWord, Pageable pageable);

    Page<Blog> findAllByCategory_Id(Integer categoryId, Pageable pageable);

    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
}
