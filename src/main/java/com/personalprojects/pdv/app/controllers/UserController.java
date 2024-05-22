package com.personalprojects.pdv.app.controllers;

import com.personalprojects.pdv.domain.entities.User;
import com.personalprojects.pdv.domain.services.UserService;
import com.personalprojects.pdv.infra.dto.UserDto;
import com.personalprojects.pdv.infra.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
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
