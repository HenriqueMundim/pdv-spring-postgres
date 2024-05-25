package com.personalprojects.pdv.domain.interfaces;

import com.personalprojects.pdv.domain.entities.Product;
import com.personalprojects.pdv.infra.dto.ProductDto;

import java.util.Optional;

public interface IProductRespository {
    Product create(Product product);
    Optional<Product> findById(String id);
}
