package ru.project.catsgram.dao;

import ru.project.catsgram.model.User;

import java.util.Optional;


public interface UserDao {
    Optional<User> findUserById(String id);
}
