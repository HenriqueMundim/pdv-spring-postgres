package com.personalprojects.pdv.domain.interfaces;

import com.personalprojects.pdv.domain.entities.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUserRepository {
    List<User> findAll();
    User findById(UUID id);
    Optional<User> findByEmail(String email);
    User save(User user);
    UserDetails findByUsername(String username);
    void delete(UUID id);
}
