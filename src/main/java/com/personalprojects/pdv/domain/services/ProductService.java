package com.personalprojects.pdv.domain.services;

import com.personalprojects.pdv.domain.entities.Product;
import com.personalprojects.pdv.domain.errors.ResourceNotFoundException;
import com.personalprojects.pdv.infra.dto.ProductDto;
import com.personalprojects.pdv.infra.mappers.ProductMapper;
import com.personalprojects.pdv.infra.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductDto findById(String id) {
        Product product = repository.findById(id).orElse(null);

        if (product == null) {
            throw new ResourceNotFoundException("Product with this ID not found");
        }

        return ProductMapper.toDto(product);
    }

    public ProductDto create(ProductDto productDto) {
        Product newProduct = repository.create(ProductMapper.toEntity(productDto));

        return ProductMapper.toDto(newProduct);
    }

    public void delete(String id) {

        Product product = repository.findById(id).orElse(null);

        if (product == null) {
            throw new ResourceNotFoundException("User with this ID not found");
        }

        repository.delete(id);
    }

}
