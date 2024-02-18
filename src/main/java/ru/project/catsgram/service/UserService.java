package ru.project.catsgram.service;

import org.springframework.stereotype.Service;

import ru.project.catsgram.exceptions.InvalidEmailException;
import ru.project.catsgram.exceptions.UserAlreadyExistException;
import ru.project.catsgram.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;


@Service
public class UserService {

    private final List<User> users = new ArrayList<>();
    private final Set<String> emailOfUsers = new HashSet<>();

    public List<User> allUsers() {
        return users;
    }

    public User createOrUpdateUser(User user)
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

    public User createUser(User user) throws UserAlreadyExistException, InvalidEmailException {
        if (user.getEmail().isEmpty() || user.getEmail() == null) {
            throw new InvalidEmailException(user.getEmail());
        } else {
            if (emailOfUsers.contains(user.getEmail())) {
                throw new UserAlreadyExistException(user.getNickname());
            } else {
                users.add(user);
                emailOfUsers.add(user.getEmail());
            }
        }
        return user;
    }

    public List<User> getUsers() {
        return users;
    }

}
