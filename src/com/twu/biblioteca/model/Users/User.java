package com.twu.biblioteca.model.Users;

public abstract class User {
    protected final String libraryNumber;
    protected final String password;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public boolean isSameLibraryNumber(String libraryNumber) {
        return this.libraryNumber.equals(libraryNumber);
    }

}
