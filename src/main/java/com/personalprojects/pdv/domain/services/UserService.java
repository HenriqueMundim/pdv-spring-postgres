package com.personalprojects.pdv.domain.services;

import com.personalprojects.pdv.app.controllers.UserController;
import com.personalprojects.pdv.domain.entities.User;
import com.personalprojects.pdv.domain.errors.ResourceAlreadyExistsException;
import com.personalprojects.pdv.domain.errors.ResourceNotFoundException;
import com.personalprojects.pdv.infra.dto.UserDto;
import com.personalprojects.pdv.infra.mappers.UserMapper;
import com.personalprojects.pdv.infra.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return  userRepository.findAll();
    }

    public UserDto findById(String id) {
        User user = userRepository.findById(id);

        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }

        UserDto userFound = UserMapper.toDto(user);
        userFound.add(linkTo(methodOn(UserController.class).findById(id)).withSelfRel());
        return userFound;
    }

    public UserDto create(UserDto userDto) {
        User user = userRepository.findByEmail(userDto.getEmail()).orElse(null);

        if (user != null) {
            throw new ResourceAlreadyExistsException("Email already registered");
        }

        UserDto newUser =  UserMapper.toDto(userRepository.save(UserMapper.toEntity(userDto)));
        newUser.add(linkTo(methodOn(UserController.class).findById(newUser.getKey())).withSelfRel());

        return newUser;
    }

    public void delete(String id) {
        User user = userRepository.findById(id);

        if (user == null) {
            throw new ResourceNotFoundException("User with this ID not found");
        }

        userRepository.delete(id);
    }
}
