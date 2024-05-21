package com.personalprojects.pdv.app.controllers;

import com.personalprojects.pdv.domain.entities.User;
import com.personalprojects.pdv.domain.services.UserService;
import com.personalprojects.pdv.infra.Dto.UserDto;
import com.personalprojects.pdv.infra.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(UserMapper.toDto(user));
    }
}
