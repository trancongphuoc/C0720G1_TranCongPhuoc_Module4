package com.codegym.service.customer;

import com.codegym.entity.customer.Customer;

public interface CustomerService {

    Customer findByIdCard(String idCard);

    Customer findByPhoneNumber(String phone);

    Customer findByEmail(String email);

    void save(Customer customer);

    Customer findByCode(String code);
}
