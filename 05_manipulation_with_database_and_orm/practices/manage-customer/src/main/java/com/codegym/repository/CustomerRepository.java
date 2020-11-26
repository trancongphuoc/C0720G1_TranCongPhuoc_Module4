package com.codegym.repository;

import com.codegym.entity.Customer;

import java.util.List;

public interface CustomerRepository {

    List<Customer> findAll();

    Customer findById(Integer id);

    void save(Customer customer);


}
