package com.twu.biblioteca.model.Users;

public class Member extends User {
    private final String name;
    private final String email;
    private final String phoneNumber;

    public Member(String libraryNumber, String password, String name, String email, String phoneNumber) {
        super(libraryNumber, password);
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("Library Number : %s\nName : %s\nE-Mail : %s\nPhone No. : %s",
                libraryNumber, name, email, phoneNumber);
    }
}
