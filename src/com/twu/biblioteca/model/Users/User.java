package com.twu.biblioteca.model.Users;

import com.twu.biblioteca.model.Role;

public class User {
    private final String libraryNumber;
    private final String password;
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final Role role;

    public User(String libraryNumber, String password, String name, String email, String phoneNumber, Role role) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public boolean isSameLibraryNumber(String libraryNumber) {
        return this.libraryNumber.equals(libraryNumber);
    }

    public String toString() {
        return String.format("Library Number : %s\nName : %s\nE-Mail : %s\nPhone No. : %s",
                libraryNumber, name, email, phoneNumber);
    }

    public Role getRole() {
        return role;
    }
}
