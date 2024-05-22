package com.personalprojects.pdv.domain.interfaces;

import com.personalprojects.pdv.domain.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<User> findAll();
    User findById(String id);
    Optional<User> findByEmail(String email);
    User create(User user);
}
