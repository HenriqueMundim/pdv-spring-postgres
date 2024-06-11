package com.personalprojects.pdv.domain.services;

import com.personalprojects.pdv.app.controllers.UserController;
import com.personalprojects.pdv.domain.entities.User;
import com.personalprojects.pdv.domain.errors.ResourceAlreadyExistsException;
import com.personalprojects.pdv.domain.errors.ResourceNotFoundException;
import com.personalprojects.pdv.infra.dto.UserDTO;
import com.personalprojects.pdv.infra.mappers.UserMapper;
import com.personalprojects.pdv.infra.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return  userRepository.findAll();
    }

    public UserDTO findById(UUID id) {
        User user = userRepository.findById(id);

        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }

        UserDTO userFound = UserMapper.toDto(user);
        userFound.add(linkTo(methodOn(UserController.class).findById(id)).withSelfRel());
        return userFound;
    }

    public void delete(UUID id) {
        User user = userRepository.findById(id);

        if (user == null) {
            throw new ResourceNotFoundException("User with this ID not found");
        }

        userRepository.delete(id);
    }
}
