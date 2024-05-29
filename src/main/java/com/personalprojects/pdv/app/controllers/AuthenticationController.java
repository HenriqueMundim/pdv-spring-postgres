package com.personalprojects.pdv.app.controllers;

import com.personalprojects.pdv.domain.entities.User;
import com.personalprojects.pdv.domain.errors.ResourceAlreadyExistsException;
import com.personalprojects.pdv.domain.services.AuthorizationService;
import com.personalprojects.pdv.domain.services.TokenService;
import com.personalprojects.pdv.infra.dto.AuthenticationDTO;
import com.personalprojects.pdv.infra.dto.RegisterUserRequestDTO;
import com.personalprojects.pdv.infra.dto.RegisterUserResponseDTO;
import com.personalprojects.pdv.infra.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @Autowired
    AuthorizationService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserRepository repository;

    @Autowired
    TokenService tokenService;

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody @Valid AuthenticationDTO data) {

        var usernamePassword = new UsernamePasswordAuthenticationToken(data.getUsername(), data.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        String token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(token);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<RegisterUserResponseDTO> register(@RequestBody @Valid RegisterUserRequestDTO data) {
        User userByEmail = repository.findByEmail(data.getEmail()).orElse(null);
        UserDetails userByUsername = repository.findByUsername(data.getUsername());

        if (userByEmail != null) {
            throw new ResourceAlreadyExistsException("User with this email already exists");
        }
        if (userByUsername != null) {
            throw new ResourceAlreadyExistsException("User with this username already exists");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.getPassword());

        User newUser = repository.save(new User(data.getName(), data.getUsername(), data.getEmail(), encryptedPassword, data.getRole()));

        return ResponseEntity.ok(new RegisterUserResponseDTO(newUser.getName(), newUser.getUsername(), newUser.getEmail()));
    }
}
