package com.personalprojects.pdv.app.controllers;

import com.personalprojects.pdv.domain.errors.StandardException;
import com.personalprojects.pdv.domain.services.UserService;
import com.personalprojects.pdv.infra.dto.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.UUID;

@RestController
@RequestMapping(value = "/users")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "User")
public class UserController {

    @Autowired
    public UserService userService;

    @Operation(
            description = "This endpoint returns a user with the specified ID",
            summary = "Get a user by ID",
            responses = {
                    @ApiResponse(
                            description = "User with this ID are found",
                            responseCode = "200"
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
    public ResponseEntity<UserDTO> findById(@PathVariable UUID id) {
        UserDTO user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @Operation(
            description = "This endpoint delete one user in our system",
            summary = "Delete a user",
            responses = {
                    @ApiResponse(
                            description = "User deleted successful",
                            responseCode = "204",
                            content = @Content
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
    @DeleteMapping(
            value = "/{id}",
            consumes = {"application/json", "application/xml", "application/x-yaml"},
            produces = {"application/json", "application/xml", "application/x-yaml"}
    )
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        userService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
