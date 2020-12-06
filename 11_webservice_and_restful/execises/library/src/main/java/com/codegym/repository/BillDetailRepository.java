package com.codegym.repository;

import com.codegym.entity.Bill;
import com.codegym.entity.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillDetailRepository extends JpaRepository<BillDetail, Integer> {

    List<BillDetail> findAllByBill(Bill bill);
}
