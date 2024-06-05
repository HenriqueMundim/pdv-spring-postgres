package com.personalprojects.pdv.domain.services;

import com.personalprojects.pdv.app.controllers.ProductController;
import com.personalprojects.pdv.domain.entities.Product;
import com.personalprojects.pdv.domain.errors.ResourceNotFoundException;
import com.personalprojects.pdv.infra.dto.ProductDTO;
import com.personalprojects.pdv.infra.mappers.ProductMapper;
import com.personalprojects.pdv.infra.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductDTO findById(String id) {
        Product product = repository.findById(id).orElse(null);

        if (product == null) {
            throw new ResourceNotFoundException("Product with this ID not found");
        }

        ProductDTO productDto = ProductMapper.toDto(product);
        productDto.add(linkTo(methodOn(ProductController.class).findById(productDto.getId())).withSelfRel());

        return productDto;
    }

    public ProductDTO create(ProductDTO productDto) {
        Product newProduct = repository.create(ProductMapper.toEntity(productDto));
        ProductDTO product = ProductMapper.toDto(newProduct);
        product.add(linkTo(methodOn(ProductController.class).findById(product.getId())).withSelfRel());
        return product;
    }

    public void delete(String id) {

        Product product = repository.findById(id).orElse(null);

        if (product == null) {
            throw new ResourceNotFoundException("User with this ID not found");
        }

        repository.delete(id);
    }

}
