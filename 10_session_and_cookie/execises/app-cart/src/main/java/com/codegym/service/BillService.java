package com.codegym.service;

import com.codegym.entity.Bill;
import com.codegym.entity.Product;
import com.codegym.entity.User;

import java.util.ArrayList;

public interface BillService {

    void save(Bill bill, User user, ArrayList<Product> productArrayList);
}
