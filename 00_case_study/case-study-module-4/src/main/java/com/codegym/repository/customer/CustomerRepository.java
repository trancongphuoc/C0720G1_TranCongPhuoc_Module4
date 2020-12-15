package com.codegym.repository.customer;

import com.codegym.entity.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByIdCard(String idCard);

    Customer findByPhone(String phoneNumber);

    Customer findByEmail(String email);

    Customer findByCode(String code);

    List<Customer> findAllByNameOrCode(String name, String code);
}
