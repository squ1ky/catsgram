package ru.project.catsgram.exceptions;

public class InvalidEmailException extends Exception {

    public InvalidEmailException(String message) {
        super(message);
    }
}
