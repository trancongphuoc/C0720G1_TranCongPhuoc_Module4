package com.codegym.service;

import com.codegym.entity.Bill;
import com.codegym.entity.Customer;

import java.util.List;
import java.util.Set;

public interface BillService {

    List<Bill> findAll();

    Bill findById(Integer id);

    void save(Bill bill);

    List<Bill> findAllByCustomer(Customer customer);

    Bill findByCodeBorrow(Integer codeBorrow);

    Bill findByCodeBorrowAndCustomer(Integer codeBorrow, Customer customer);
}
