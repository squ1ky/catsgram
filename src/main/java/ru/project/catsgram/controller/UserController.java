package ru.project.catsgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.project.catsgram.model.User;
import ru.project.catsgram.service.UserService;
import ru.project.catsgram.exceptions.InvalidEmailException;
import ru.project.catsgram.exceptions.UserAlreadyExistException;

import java.util.Optional;
import java.util.List;


@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> allUsers() {
        logger.info("Количество пользователей в данный момент: " + userService.getUsers().size());
        return userService.allUsers();
    }

    @GetMapping("/users/{email}")
    public Optional<User> findByEmail(@PathVariable String email) {
        return userService.getUsers().stream()
                .filter(x -> x.getEmail().equals(email))
                .findFirst();
    }

    @PutMapping("/user")
    public User createOrUpdateUser(@RequestBody User user)
            throws InvalidEmailException, UserAlreadyExistException {
        return userService.createOrUpdateUser(user);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) throws UserAlreadyExistException, InvalidEmailException {
        logger.info("Создан новый пользователь: " + user.getNickname());
        return userService.createUser(user);
    }

}
