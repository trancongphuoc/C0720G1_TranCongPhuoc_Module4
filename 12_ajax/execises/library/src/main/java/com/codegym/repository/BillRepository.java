package com.codegym.repository;

import com.codegym.entity.Bill;
import com.codegym.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Integer> {

    List<Bill> findAllByCustomer(Customer customer);

    Bill findByCodeBorrow(Integer codeBorrow);

    Bill findByCodeBorrowAndCustomer(Integer codeBorrow, Customer customer);
}
