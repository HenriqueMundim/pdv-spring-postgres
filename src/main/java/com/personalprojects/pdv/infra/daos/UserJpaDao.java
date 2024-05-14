package com.personalprojects.pdv.infra.daos;

import com.personalprojects.pdv.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaDao extends JpaRepository<User, String> { }
