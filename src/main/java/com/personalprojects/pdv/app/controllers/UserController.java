package com.personalprojects.pdv.app.controllers;

import com.personalprojects.pdv.domain.errors.StandardException;
import com.personalprojects.pdv.domain.services.UserService;
import com.personalprojects.pdv.infra.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
@Tag(name = "User")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping(
            value = "/{id}",
            produces = {"application/json", "application/xml", "application/x-yaml"}
    )
    public ResponseEntity<UserDto> findById(@PathVariable String id) {
        UserDto user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @Operation(
            description = "This endpoint register a new user in our system",
            summary = "Register a new user",
            responses = {
                    @ApiResponse(
                            description = "User registered successful",
                            responseCode = "201"
                    ),
                    @ApiResponse(
                            description = "User with this email already exists",
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
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
        UserDto newUser = userService.create(userDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @DeleteMapping(
            value = "/{id}",
            consumes = {"application/json", "application/xml", "application/x-yaml"}
    )
    public ResponseEntity<?> delete(@PathVariable String id) {
        userService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
