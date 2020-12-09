package com.codegym.service.impl;

import com.codegym.entity.Bill;
import com.codegym.entity.Customer;
import com.codegym.repository.BillRepository;
import com.codegym.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    BillRepository billRepository;

    @Override
    public List<Bill> findAll() {
        return billRepository.findAll();
    }

    @Override
    public Bill findById(Integer id) {
        return billRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Bill bill) {
        billRepository.save(bill);
    }

    @Override
    public List<Bill> findAllByCustomer(Customer customer) {
        return billRepository.findAllByCustomer(customer);
    }

    @Override
    public Bill findByCodeBorrow(Integer codeBorrow) {
        return billRepository.findByCodeBorrow(codeBorrow);
    }

    @Override
    public Bill findByCodeBorrowAndCustomer(Integer codeBorrow, Customer customer) {
        return billRepository.findByCodeBorrowAndCustomer(codeBorrow, customer);
    }
}
