package com.example.usersTestTask.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id){
        super("Пользователь с " + id + " не найден");
    }
}
