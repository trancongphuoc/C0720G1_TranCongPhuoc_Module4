package com.codegym.service;

import com.codegym.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(Integer id);

    void save(Customer customer);
}
