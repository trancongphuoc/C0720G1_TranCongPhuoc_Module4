package com.codegym.service;

import com.codegym.entity.BillDetail;
import com.codegym.entity.User;

import java.util.List;

public interface BillDetailService {

    List<BillDetail> findAll();

    void save(BillDetail billDetail);

    List<BillDetail> findAllByUser(User user);
}
