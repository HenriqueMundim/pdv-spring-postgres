package com.personalprojects.pdv.infra.repositories;

import com.personalprojects.pdv.domain.entities.User;
import com.personalprojects.pdv.domain.interfaces.IUserRepository;
import com.personalprojects.pdv.infra.daos.UserJpaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {

    @Autowired
    UserJpaDao userJpaDao;

    @Override
    public List<User> findAll() {
        return userJpaDao.findAll();
    }

    @Override
    public User findById(String id) {
        return userJpaDao.findById(id).orElse(null);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userJpaDao.findByEmail(email);
    }

    public User save(User user) {
        return userJpaDao.save(user);
    }

    public void delete(String id) {
        userJpaDao.deleteById(id);
    }
}
