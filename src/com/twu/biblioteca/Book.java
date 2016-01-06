package com.twu.biblioteca;

public class Book {
    private int bookId;
    private final String name;
    private final String authorName;
    private final int yearPublished;

    public Book(int bookId, String name, String authorName, int yearPublished) {
        this.bookId = bookId;
        this.name = name;
        this.authorName = authorName;
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return String.format("%d %-25s %-20s %d", bookId, name, authorName, yearPublished);
    }

    public boolean isSameBookId(int id) {
        return this.bookId == id;
    }

}
