package com.personalprojects.pdv.domain.services;

import com.personalprojects.pdv.domain.entities.Order;
import com.personalprojects.pdv.domain.entities.User;
import com.personalprojects.pdv.domain.errors.ResourceNotFoundException;
import com.personalprojects.pdv.infra.dto.RegisterOrderRequestDTO;
import com.personalprojects.pdv.infra.dto.RegisterOrderResponseDTO;
import com.personalprojects.pdv.infra.mappers.OrderMapper;
import com.personalprojects.pdv.infra.repositories.OrderRepository;
import com.personalprojects.pdv.infra.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final UserRepository userRepository;

    @Autowired
    public OrderService(OrderRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public RegisterOrderResponseDTO create(RegisterOrderRequestDTO order) {

        User user = userRepository.findById(UUID.fromString(order.getUserId()));

        if (user == null) {
            throw new ResourceNotFoundException("Not possible create a new order because a user with this ID not found");
        }

        Order newOrder = repository.save(new Order(order.getDate(), user));

        return OrderMapper.toCreateResponse(newOrder);
    }

    public RegisterOrderResponseDTO findById(UUID id) {
        Order order = repository.findById(id).orElse(null);

        if (order == null) {
            throw new ResourceNotFoundException("Order with ID: " + id + "not found");
        }

        return OrderMapper.toCreateResponse(order);
    }

    public List<RegisterOrderResponseDTO> findByUser(UUID id) {
        User user = userRepository.findById(id);

        if (user == null) {
            throw new ResourceNotFoundException("User with ID" + id + " not found");
        }

        List<Order> orders = repository.findOrderByUser(id).orElse(null);

        if (user == orders) {
            throw new ResourceNotFoundException("User with ID" + id + " don't have orders");
        }

        return orders.stream().map(OrderMapper::toCreateResponse).toList();
    }
}
