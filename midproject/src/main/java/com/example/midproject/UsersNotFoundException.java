package com.example.midproject;

public class UsersNotFoundException extends RuntimeException {
    public UsersNotFoundException(Integer id) {
        super("Could not find anime" + id);
    }
}