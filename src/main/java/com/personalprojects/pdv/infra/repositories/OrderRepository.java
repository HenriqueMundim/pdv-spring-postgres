package com.personalprojects.pdv.infra.repositories;

import com.personalprojects.pdv.domain.entities.Order;
import com.personalprojects.pdv.infra.daos.OrderJpaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class OrderRepository {

    private final OrderJpaDao dao;

    @Autowired
    public OrderRepository(OrderJpaDao dao) {
        this.dao = dao;
    }

    public Order save(Order order) {
        return this.dao.save(order);
    }

    public Optional<Order> findById(UUID id) {
        return this.dao.findById(id);
    }

    public Optional<List<Order>> findOrderByUser(UUID id) {
        return dao.findOrderByUser(id);
    }

}
