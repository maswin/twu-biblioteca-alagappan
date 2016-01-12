package com.twu.biblioteca.controller;

import com.twu.biblioteca.Exception.UserOperationException;
import com.twu.biblioteca.model.Users.User;

import java.util.List;
import java.util.Optional;

public class Authenticator {
    private List<User> users;

    public Authenticator(List<User> users) {
        this.users = users;
    }

    public User authenticate(String libraryNumber, String password) throws UserOperationException {
        Optional<User> foundUser = users.stream().filter(user -> user.isSameLibraryNumber(libraryNumber)
                && user.checkPassword(password)).findFirst();
        if(foundUser.isPresent()) {
            return foundUser.get();
        }
        throw new UserOperationException("User not found");
    }

}
