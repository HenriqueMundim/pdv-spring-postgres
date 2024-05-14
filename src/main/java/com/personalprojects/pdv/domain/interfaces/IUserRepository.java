package com.personalprojects.pdv.domain.interfaces;

import com.personalprojects.pdv.domain.entities.User;

import java.util.List;

public interface IUserRepository {
    List<User> findAll();
}
