package com.personalprojects.pdv.domain.interfaces;

import com.personalprojects.pdv.domain.entities.Product;

import java.util.Optional;
import java.util.UUID;

public interface IProductRepository {
    Product create(Product product);
    Optional<Product> findById(UUID id);
    void delete(UUID id);
}
