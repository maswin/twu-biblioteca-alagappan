package com.twu.biblioteca.Books;

public class Copy {
    private final int isbn;
    private boolean isBorrowed;

    public Copy(int isbn, boolean isBorrowed) {
        this.isbn = isbn;
        this.isBorrowed = isBorrowed;
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
}
