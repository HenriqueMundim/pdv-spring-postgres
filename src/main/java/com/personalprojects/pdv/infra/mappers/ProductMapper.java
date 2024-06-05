package com.personalprojects.pdv.infra.mappers;

import com.personalprojects.pdv.domain.entities.Product;
import com.personalprojects.pdv.infra.dto.ProductDTO;

public class ProductMapper {
    public static ProductDTO toDto(Product product) {
        ProductDTO productDto = new ProductDTO();
        productDto.setId(product.getId());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());

        return productDto;
    }

    public static Product toEntity(ProductDTO productDto) {
        Product product = new Product();
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());

        return product;
    }
}
