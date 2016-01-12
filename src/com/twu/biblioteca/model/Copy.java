package com.twu.biblioteca.model;

import com.twu.biblioteca.model.Users.User;

public class Copy {

    private final int isbn;
    private User borrowedUser;

    public Copy(int isbn, User borrowedUser) {
        this.isbn = isbn;
        this.borrowedUser = borrowedUser;
    }

    public void checkOut(User user) {
        this.borrowedUser = user;
    }

    public boolean isBorrowed() {
        return borrowedUser!=null;
    }

    public void checkIn() {
        borrowedUser = null;
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
