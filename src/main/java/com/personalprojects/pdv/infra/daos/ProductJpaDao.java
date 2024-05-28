package com.personalprojects.pdv.infra.daos;

import com.personalprojects.pdv.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaDao extends JpaRepository<Product, String> { }
