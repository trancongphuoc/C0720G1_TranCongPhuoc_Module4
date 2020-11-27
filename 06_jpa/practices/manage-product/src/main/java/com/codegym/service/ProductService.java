package com.codegym.service;

import com.codegym.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAllProduct();

    Product findProductById(Integer id);

    void saveProduct(Product product);


    void deleteProduct(Integer id);
}
