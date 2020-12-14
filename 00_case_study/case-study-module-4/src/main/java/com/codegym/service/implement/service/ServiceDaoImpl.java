package com.codegym.service.implement.service;

import com.codegym.repository.service.ServiceRepository;
import com.codegym.service.service.ServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ServiceDaoImpl implements ServiceDao {

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Page<com.codegym.entity.service.Service> findAll(Pageable pageable) {
        return serviceRepository.findAll(pageable);
    }

    @Override
    public com.codegym.entity.service.Service findById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }
}
