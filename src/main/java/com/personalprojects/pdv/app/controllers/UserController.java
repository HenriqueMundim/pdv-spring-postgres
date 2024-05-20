package com.personalprojects.pdv.app.controllers;

import com.personalprojects.pdv.domain.entities.User;
import com.personalprojects.pdv.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }
}
