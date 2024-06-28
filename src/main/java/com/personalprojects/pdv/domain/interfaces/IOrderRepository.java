package com.personalprojects.pdv.domain.interfaces;

import com.personalprojects.pdv.domain.entities.Order;

import java.util.List;
import java.util.UUID;

public interface IOrderRepository {
    Order save(Order order);
    Order findById(UUID id);
    List<Order> findOrderByUser(UUID id);
}
