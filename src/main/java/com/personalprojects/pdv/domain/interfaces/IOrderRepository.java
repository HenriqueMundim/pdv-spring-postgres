package com.personalprojects.pdv.domain.interfaces;

import com.personalprojects.pdv.domain.entities.Order;

public interface IOrderRepository {
    Order save(Order order);
}
