package com.twu.biblioteca.model;

import com.twu.biblioteca.model.Users.User;

public class Copy {

    private final int isbn;
    private boolean isBorrowed;
    private User borrowedUser;

    public Copy(int isbn, boolean isBorrowed, User borrowedUser) {
        this.isbn = isbn;
        this.isBorrowed = isBorrowed;
        this.borrowedUser = borrowedUser;
    }

    public void checkOut(User user) {
        isBorrowed = true;
        this.borrowedUser = user;
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

    public boolean isThisTheBorrowedUser(User user) {
        return this.borrowedUser.equals(user);
    }

}
