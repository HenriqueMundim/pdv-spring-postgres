package com.personalprojects.pdv.domain.interfaces;

import com.personalprojects.pdv.domain.entities.Product;

import java.util.Optional;

public interface IProductRepository {
    Product create(Product product);
    Optional<Product> findById(String id);
    void delete(String id);
}
