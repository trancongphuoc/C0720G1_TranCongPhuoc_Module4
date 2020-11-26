package com.codegym.repository.impl;

import com.codegym.entity.Product;
import com.codegym.repository.BaseRepository;
import com.codegym.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Override
    public List<Product> findAllProduct() {
        TypedQuery<Product> typedQuery =
                BaseRepository.entityManager.createQuery(
                        "select p from product p", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public Product findProductById(Integer id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public void saveProduct(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        if (product.getId() != null) {
            BaseRepository.entityManager.merge(product);
        } else {
            BaseRepository.entityManager.persist(product);
        }
        entityTransaction.commit();

    }

    @Override
    public void deleteProduct(Integer id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(findProductById(id));
        entityTransaction.commit();
    }
}
