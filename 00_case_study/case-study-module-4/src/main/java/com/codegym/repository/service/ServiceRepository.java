package com.codegym.repository.service;

import com.codegym.entity.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
}
