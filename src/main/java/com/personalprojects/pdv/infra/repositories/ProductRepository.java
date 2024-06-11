package com.personalprojects.pdv.infra.repositories;

import com.personalprojects.pdv.domain.entities.Product;
import com.personalprojects.pdv.domain.interfaces.IProductRepository;
import com.personalprojects.pdv.infra.daos.ProductJpaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class ProductRepository implements IProductRepository {

    @Autowired
    private ProductJpaDao productJpaDao;

    @Override
    public Product create(Product product) {
        return productJpaDao.save(product);
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return productJpaDao.findById(id);
    }

    @Override
    public void delete(UUID id) {
        productJpaDao.deleteById(id);
    }
}
