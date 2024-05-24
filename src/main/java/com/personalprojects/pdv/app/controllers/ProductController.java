package com.personalprojects.pdv.app.controllers;

import com.personalprojects.pdv.domain.entities.Product;
import com.personalprojects.pdv.domain.services.ProductService;
import com.personalprojects.pdv.infra.dto.ProductDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Product")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @Operation(
            description = "This endpoint is responsible for register a new product in our system",
            summary = "Register a new product",
            responses = {
                    @ApiResponse(
                            description = "Product successful registered",
                            responseCode = "201",
                            content = {
                                    @Content(schema = @Schema(implementation = ProductDto.class))
                            }
                    )
            }
    )
    @PostMapping(
            consumes = {"application/json", "application/xml", "application/x-yaml"},
            produces = {"application/json", "application/xml", "application/x-yaml"}
    )
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto product) {
        ProductDto newProduct = service.create(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }
}
