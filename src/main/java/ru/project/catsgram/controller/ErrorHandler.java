package ru.project.catsgram.controller;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import ru.project.catsgram.exceptions.*;


@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handlePostNotFoundException() {
        return "Пост не найден.";
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleUserNotFoundException(final UserNotFoundException e) {
        return "Пользователь " + e.getMessage() + " не найден.";
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleUserAlreadyExistException(final UserAlreadyExistException e) {
        return "Пользователь " + e.getMessage() + " уже существует.";
    }

    @ExceptionHandler(InvalidEmailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidEmailException(final InvalidEmailException e) {
        return "Email " + e.getMessage() + " неверный.";
    }

    @ExceptionHandler(IncorrectParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIncorrectParameterException(final IncorrectParameterException e) {
        return "Ошибка с полем " + e.getMessage();
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleThrowable(final Throwable t) {
        return t.getMessage();
    }
}
