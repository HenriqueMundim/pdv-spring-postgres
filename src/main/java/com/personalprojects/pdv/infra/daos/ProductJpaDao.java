package com.personalprojects.pdv.infra.daos;

import com.personalprojects.pdv.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductJpaDao extends JpaRepository<Product, UUID> { }
