package com.codegym.service.impl;

import com.codegym.entity.BillDetail;
import com.codegym.entity.User;
import com.codegym.repository.BillDetailRepository;
import com.codegym.service.BillDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BillDetailServiceImpl implements BillDetailService {

    @Autowired
    BillDetailRepository billDetailRepository;

    @Override
    public List<BillDetail> findAll() {
        return billDetailRepository.findAll();
    }

    @Override
    public void save(BillDetail billDetail) {
        billDetailRepository.save(billDetail);
    }

    @Override
    public List<BillDetail> findAllByUser(User user) {
        return billDetailRepository.findAllByBillUser(user);
    }
}
