package com.personalprojects.pdv.domain.services;

import com.personalprojects.pdv.domain.entities.User;
import com.personalprojects.pdv.domain.errors.ResourceNotFoundException;
import com.personalprojects.pdv.infra.repositories.UserRepository;
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
}
