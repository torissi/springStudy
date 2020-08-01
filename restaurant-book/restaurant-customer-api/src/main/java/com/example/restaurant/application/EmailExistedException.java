package com.example.restaurant.application;

class EmailExistedException extends RuntimeException{

    EmailExistedException(String email) {
        super("Email is already registerrd: " + email);
    }
}
