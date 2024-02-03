package ru.project.catsgram.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.project.catsgram.model.User;
import ru.project.catsgram.exceptions.InvalidEmailException;
import ru.project.catsgram.exceptions.UserAlreadyExistException;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    List<User> users = new ArrayList<>();
    Set<String> emailOfUsers = new HashSet<>();


    @GetMapping
    public List<User> allUsers() {
        logger.info("Количество пользователей в данный момент: " + users.size());
        return users;
    }

    @PutMapping
    public User createOrUpdateUser(@RequestBody User user)
            throws InvalidEmailException, UserAlreadyExistException {

        if (emailOfUsers.contains(user.getEmail())) {
            for (User currentUser : users) {
                if (currentUser.getEmail().equals(user.getEmail())) {
                    currentUser.setNickname(user.getNickname());
                    currentUser.setBirthdate(user.getBirthdate());
                    return user;
                }
            }
        }

        User currentUser = new User(user.getEmail(), user.getNickname(), user.getBirthdate());
        createUser(currentUser);
        return currentUser;

    }

    @PostMapping
    public User createUser(@RequestBody User user) throws UserAlreadyExistException, InvalidEmailException {
        if (user.getEmail().isEmpty() || user.getEmail() == null) {
            throw new InvalidEmailException("Неправильный формат e-mail");
        } else {
            if (emailOfUsers.contains(user.getEmail())) {
                throw new UserAlreadyExistException("Данный e-mail уже занят.");
            } else {
                users.add(user);
                emailOfUsers.add(user.getEmail());
            }
        }
        logger.info("Создан новый пользователь: " + user.getNickname());
        return user;
    }
}
