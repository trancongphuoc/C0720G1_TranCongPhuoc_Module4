package com.codegym.service;

import com.codegym.entity.Bill;
import com.codegym.entity.BillDetail;

import java.util.List;
import java.util.Set;

public interface BillDetailService {

    List<BillDetail> findAll();

    BillDetail findById(Integer id);

    void save(BillDetail billDetail);

    void saveAll(Set<BillDetail> billDetailSet);

    List<BillDetail> findAllByBill(Bill bill);
}
