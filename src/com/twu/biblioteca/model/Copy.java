package com.twu.biblioteca.model;

import com.twu.biblioteca.model.Users.User;

public class Copy {

    private final int isbn;
    private boolean isBorrowed;
    private User user;

    public Copy(int isbn, boolean isBorrowed, User user) {
        this.isbn = isbn;
        this.isBorrowed = isBorrowed;
        this.user = user;
    }

    public void checkOut() {
        isBorrowed = true;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void checkIn() {
        isBorrowed = false;
    }

    public int getIsbn() {
        return isbn;
    }

    public boolean isSameIsbn(int isbn) {
        return this.isbn == isbn;
    }

}
