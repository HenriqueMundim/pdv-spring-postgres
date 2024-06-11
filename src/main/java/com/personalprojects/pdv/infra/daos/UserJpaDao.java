package com.personalprojects.pdv.infra.daos;

import com.personalprojects.pdv.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserJpaDao extends JpaRepository<User, UUID> {
    @Query(value = "SELECT us FROM User us WHERE us.email = ?1")
    Optional<User> findByEmail(String email);

    UserDetails findByUsername(String username);
}
