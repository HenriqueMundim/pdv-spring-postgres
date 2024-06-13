package com.personalprojects.pdv.infra.mappers;

import com.personalprojects.pdv.domain.entities.Order;
import com.personalprojects.pdv.infra.dto.RegisterOrderResponseDTO;

public class OrderMapper {

    public static RegisterOrderResponseDTO toCreateResponse(Order order) {
        RegisterOrderResponseDTO newOrder = new RegisterOrderResponseDTO();
        newOrder.setId(order.getId());
        newOrder.setDate(order.getDate());
        newOrder.setClient(UserMapper.toDomainOutput(order.getClient()));
        newOrder.setItems(order.getItems());

        return newOrder;
    }

}
