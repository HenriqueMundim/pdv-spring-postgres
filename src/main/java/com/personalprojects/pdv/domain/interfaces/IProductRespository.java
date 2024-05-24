package com.personalprojects.pdv.domain.interfaces;

import com.personalprojects.pdv.domain.entities.Product;
import com.personalprojects.pdv.infra.dto.ProductDto;

public interface IProductRespository {
    Product create(Product product);
}
