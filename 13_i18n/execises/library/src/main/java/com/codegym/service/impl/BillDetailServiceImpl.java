package com.codegym.service.impl;

import com.codegym.entity.Bill;
import com.codegym.entity.BillDetail;
import com.codegym.repository.BillDetailRepository;
import com.codegym.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BillDetailServiceImpl implements BillDetailService {

    @Autowired
    BillDetailRepository billDetailRepository;


    @Override
    public List<BillDetail> findAll() {
        return billDetailRepository.findAll();
    }

    @Override
    public BillDetail findById(Integer id) {
        return billDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void save(BillDetail billDetail) {
        billDetailRepository.save(billDetail);
    }

    @Override
    public void saveAll(Set<BillDetail> billDetailSet) {
        billDetailRepository.saveAll(billDetailSet);
    }

    @Override
    public List<BillDetail> findAllByBill(Bill bill) {
        return billDetailRepository.findAllByBill(bill);
    }
}
