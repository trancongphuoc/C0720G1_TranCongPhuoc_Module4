package com.codegym.repository;

import com.codegym.entity.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAllProduct();

    Product findProductById(Integer id);

    void saveProduct(Product product);


    void deleteProduct(Integer id);
}
