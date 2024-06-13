package com.personalprojects.pdv.app.controllers;

import com.personalprojects.pdv.domain.errors.StandardException;
import com.personalprojects.pdv.domain.services.OrderService;
import com.personalprojects.pdv.infra.dto.RegisterOrderRequestDTO;
import com.personalprojects.pdv.infra.dto.RegisterOrderResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Order")
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private final OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @Operation(
            description = "Endpoint responsible to permit a registration of a new order",
            summary = "Register new order",
            responses = {
                    @ApiResponse(
                            description = "Order successful created",
                            responseCode = "201",
                            content = {
                                    @Content(
                                            schema = @Schema(implementation = RegisterOrderResponseDTO.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            description = "Client not found",
                            responseCode = "404",
                            content = {
                                    @Content(
                                            schema = @Schema(implementation = StandardException.class)
                                    )
                            }
                    )
            }
    )
    @PostMapping(
            consumes = {"application/json", "application/xml", "application/x-yaml"},
            produces = {"application/json", "application/xml", "application/x-yaml"}
    )
    public ResponseEntity<RegisterOrderResponseDTO> create(@RequestBody @Valid RegisterOrderRequestDTO order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(order));
    }
}
