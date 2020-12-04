package com.codegym.service.impl;

import com.codegym.entity.Bill;
import com.codegym.entity.BillDetail;
import com.codegym.entity.Product;
import com.codegym.entity.User;
import com.codegym.repository.BillRepository;
import com.codegym.service.BillDetailService;
import com.codegym.service.BillService;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    BillDetailService billDetailService;

    @Autowired
    BillRepository billRepository;

    @Autowired
    ProductService productService;

    @Override
    public void save(Bill bill, User user, ArrayList<Product> productArrayList) {
        Double totalMoney = 0.0;
        bill.setDateBuy(LocalDate.now().toString());
//        bill.setUser(user);
        bill = billRepository.save(bill);
        for (Product product : productArrayList) {
            BillDetail billDetail = new BillDetail();
            billDetail.setBill(bill);
            totalMoney += product.getPrice();
            Product product1 = productService.findById(product.getId());
            billDetail.setProduct(product1);
            billDetailService.save(billDetail);
        }

        bill.setUser(user);
        bill.setTotalMoney(totalMoney);
        billRepository.save(bill);

    }
}
