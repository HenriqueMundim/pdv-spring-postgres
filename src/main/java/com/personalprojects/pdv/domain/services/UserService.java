package com.personalprojects.pdv.domain.services;

import com.personalprojects.pdv.domain.entities.User;
import com.personalprojects.pdv.domain.errors.ResourceAlreadyExistsException;
import com.personalprojects.pdv.domain.errors.ResourceNotFoundException;
import com.personalprojects.pdv.infra.Dto.UserDto;
import com.personalprojects.pdv.infra.mappers.UserMapper;
import com.personalprojects.pdv.infra.repositories.UserRepository;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return  userRepository.findAll();
    }

    public User findById(String id) {
        User user = userRepository.findById(id);

        if (user == null) {
            throw new ResourceNotFoundException("User not found");
        }

        return user;
    }

    public UserDto create(UserDto userDto) {
        User user = userRepository.findByEmail(userDto.getEmail()).orElse(null);

        if (user != null) {
            throw new ResourceAlreadyExistsException("Email already registered");
        }

        return UserMapper.toDto(userRepository.save(UserMapper.toEntity(userDto)));
    }
}
