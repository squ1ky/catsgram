package ru.project.catsgram.service;

import org.springframework.stereotype.Service;

import ru.project.catsgram.dao.UserDao;
import ru.project.catsgram.model.User;

import java.util.Optional;


@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Optional<User> findUserById(String id) {
        return userDao.findUserById(id);
    }
}