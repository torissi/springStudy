package com.example.restaurant.application;

public class PasswordWrongException extends RuntimeException{

    PasswordWrongException() {
        super("Password is Wrong");
    }
}
