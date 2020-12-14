package com.codegym.service.service;

import com.codegym.entity.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ServiceDao {
    Page<Service> findAll(Pageable pageable);

    Service findById(Long id);
}
