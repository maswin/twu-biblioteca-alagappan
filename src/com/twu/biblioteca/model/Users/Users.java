package com.twu.biblioteca.model.Users;

import com.twu.biblioteca.Exception.UserOperationException;

import java.util.List;
import java.util.Optional;

public class Users {
    private List<User> users;

    public Users(List<User> users) {
        this.users = users;
    }

    public User findUserByLibraryNumberAndPassword(String libraryNumber, String password) throws UserOperationException {
        Optional<User> foundUser = users.stream().filter(user -> user.isSameLibraryNumber(libraryNumber)
                && user.checkPassword(password)).findFirst();
        if(foundUser.isPresent()) {
            return foundUser.get();
        }
        throw new UserOperationException("User not found");
    }

}
