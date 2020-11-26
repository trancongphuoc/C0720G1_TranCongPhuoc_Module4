package com.codegym.service.implement;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();

        productMap.put(1, new Product(1, "M4A1", 2000000, "Microsoft"));
        productMap.put(2, new Product(2, "May bay", 6000000, "Apple"));
        productMap.put(3, new Product(3, "Coca cola", 50000, "Pepsi"));
        productMap.put(4, new Product(4, "Ao giap", 100000, "Nokia"));
        productMap.put(5, new Product(5, "Dep tong", 300000000, "Samsung"));
    }

    @Override
    public List<Product> selectAllProduct() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product selectProductById(int id) {
        return productMap.get(id);
    }

    @Override
    public void insertProduct(Product product) {
        product.setId(productMap.get(productMap.size()-1).getId() + 1);
        productMap.put(product.getId(), product);
    }

    @Override
    public void updateProduct(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void deleteProduct(int id) {
        productMap.remove(id);
    }
}
