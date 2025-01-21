package com.solvd.carina.saucedemo.services;

import com.solvd.carina.saucedemo.models.User;
import com.solvd.carina.saucedemo.utils.ConnectionFactory;

import java.util.NoSuchElementException;

public class UserService {
    public User getUserById(int id) {
        User user = ConnectionFactory.getUserMapper().findById(id);
        if (user == null) {
            throw new NoSuchElementException("User with ID " + id + " not found.");
        }
        return user;
    }
}
