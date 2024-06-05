package com.personalprojects.pdv.domain.interfaces;

import com.personalprojects.pdv.domain.entities.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<User> findAll();
    User findById(String id);
    Optional<User> findByEmail(String email);
    User save(User user);
    UserDetails findByUsername(String username);
    void delete(String id);
}
