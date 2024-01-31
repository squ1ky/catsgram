package ru.project.catsgram.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import ru.project.catsgram.User;
import ru.project.catsgram.exceptions.InvalidEmailException;
import ru.project.catsgram.exceptions.UserAlreadyExistException;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

@RestController
public class UserController {

    List<User> users = new ArrayList<>();
    Set<String> emailOfUsers = new HashSet<>();


    @GetMapping("/users")
    public List<User> allUsers() {
        return users;
    }

//    @PutMapping("/users")
//    public User createOrUpdateUser(@RequestBody User user) throws InvalidEmailException {
//        if (emailOfUsers.contains(user.getEmail())) {
//
//        } else {
//
//        }
//    }


    @PostMapping("/user")
    public User createUser(@RequestBody User user) throws UserAlreadyExistException, InvalidEmailException {
        if (user.getEmail().isEmpty() || user.getEmail() == null) {
            throw new InvalidEmailException("Неправильный формат e-mail");
        } else {
            if (emailOfUsers.contains(user.getEmail())) {
                throw new UserAlreadyExistException("Данный e-mail уже занят.");
            } else {
                users.add(user);
                emailOfUsers.add(user.getEmail());
                return user;
            }
        }
    }
}
