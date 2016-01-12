package com.twu.biblioteca.model.Users;

public class User {
    private final String libraryNumber;
    private final String password;
    private final String name;
    private final String email;
    private final String phoneNumber;

    public User(String libraryNumber, String password, String name, String email, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public boolean isSameLibraryNumber(String libraryNumber) {
        return this.libraryNumber.equals(libraryNumber);
    }

    @Override
    public String toString() {
        return String.format("Library Number : %s\nName : %s\nE-Mail : %s\nPhone No. : %s",
                libraryNumber, name, email, phoneNumber);
    }
}
