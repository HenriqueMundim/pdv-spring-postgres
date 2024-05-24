package com.personalprojects.pdv.infra.repositories;

import com.personalprojects.pdv.domain.entities.Product;
import com.personalprojects.pdv.domain.interfaces.IProductRespository;
import com.personalprojects.pdv.infra.dto.ProductDto;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRespository implements IProductRespository {
    @Override
    public Product create(ProductDto productDto) {
        return null;
    }
}
