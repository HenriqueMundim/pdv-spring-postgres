package com.personalprojects.pdv.infra.repositories;

import com.personalprojects.pdv.domain.entities.Product;
import com.personalprojects.pdv.domain.interfaces.IProductRespository;
import com.personalprojects.pdv.infra.daos.ProductJpaDao;
import com.personalprojects.pdv.infra.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRespository implements IProductRespository {

    @Autowired
    private ProductJpaDao productJpaDao;

    @Override
    public Product create(Product product) {
        return productJpaDao.save(product);
    }
}
