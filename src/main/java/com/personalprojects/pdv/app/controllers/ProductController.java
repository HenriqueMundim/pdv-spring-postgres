package com.personalprojects.pdv.app.controllers;

import com.personalprojects.pdv.domain.errors.StandardException;
import com.personalprojects.pdv.domain.services.ProductService;
import com.personalprojects.pdv.infra.dto.ProductDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Product")
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @Operation(
            description = "This endpoint is responsible for get a product by id",
            summary = "Get product by ID",
            responses = {
                    @ApiResponse(
                            description = "User successful found",
                            responseCode = "200",
                            content = {
                                    @Content(
                                            schema = @Schema(implementation = ProductDTO.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            description = "User with this ID not found",
                            responseCode = "404",
                            content = {
                                    @Content(
                                            schema = @Schema(implementation = StandardException.class)
                                    )
                            }
                    )
            }
    )
    @GetMapping(
            value = "/{id}",
            produces = {"application/json", "application/xml", "application/x-yaml"}
    )
    public ResponseEntity<ProductDTO> findById(@PathVariable UUID id) {
        ProductDTO product = service.findById(id);

        return ResponseEntity.ok().body(product);
    }

    @Operation(
            description = "This endpoint is responsible for register a new product in our system",
            summary = "Register a new product",
            responses = {
                    @ApiResponse(
                            description = "Product successful registered",
                            responseCode = "201",
                            content = {
                                    @Content(schema = @Schema(implementation = ProductDTO.class))
                            }
                    )
            }
    )
    @PostMapping(
            consumes = {"application/json", "application/xml", "application/x-yaml"},
            produces = {"application/json", "application/xml", "application/x-yaml"}
    )
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO product) {
        ProductDTO newProduct = service.create(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @Operation(
            description = "This endpoint is responsible for delete a product in our system",
            summary = "Delete a product",
            responses = {
                    @ApiResponse(
                            description = "Product not found",
                            responseCode = "404",
                            content = {
                                    @Content(
                                            schema = @Schema(implementation = StandardException.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            description = "Product successful deleted",
                            responseCode = "204",
                            content = @Content
                    )
            }
    )
    @DeleteMapping(
            value = "/{id}",
            produces = {"application/json", "application/xml", "application/x-yaml"}
    )
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
