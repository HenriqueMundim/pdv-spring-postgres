package com.personalprojects.pdv.app.controllers;

import com.personalprojects.pdv.domain.entities.Order;
import com.personalprojects.pdv.domain.services.OrderService;
import com.personalprojects.pdv.infra.dto.RegisterOrderRequestDTO;
import com.personalprojects.pdv.infra.dto.RegisterOrderResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private final OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RegisterOrderResponseDTO> create(@RequestBody @Valid RegisterOrderRequestDTO order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(order));
    }
}
