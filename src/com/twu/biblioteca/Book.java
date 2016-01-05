package com.twu.biblioteca;

public class Book {
    private int bookId;
    private final String name;
    private final String authorName;
    private final int yearPublished;
    private boolean isAvailable;

    public Book(int bookId, String name, String authorName, int yearPublished, boolean isAvailable) {
        this.bookId = bookId;
        this.name = name;
        this.authorName = authorName;
        this.yearPublished = yearPublished;
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return String.format("%d %-25s %-20s %d", bookId, name, authorName, yearPublished);
    }

    public boolean isSameBookId(int id) {
        return this.bookId == id;
    }

    public boolean isBookAvailable() {
        return isAvailable;
    }

    public void checkIn() {
        this.isAvailable = true;
    }

    public void checkOut() {
        this.isAvailable = false;
    }
}
