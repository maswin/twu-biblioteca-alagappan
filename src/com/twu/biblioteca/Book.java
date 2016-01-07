package com.twu.biblioteca;

import java.util.List;

public class Book {
    private final int bookId;
    private final String name;
    private final String authorName;
    private final int yearPublished;
    private List<Integer> isbn;

    public Book(int bookId, String name, String authorName, int yearPublished, List<Integer> isbn) {
        this.bookId = bookId;
        this.name = name;
        this.authorName = authorName;
        this.yearPublished = yearPublished;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        if(isAnyBookAvailable()) {
            return String.format("%-6d %-12d %-25s %-20s %d", bookId, getFirstISBN(), name, authorName, yearPublished);
        } else {
            return String.format("%-6d %-12s %-25s %-20s %d", bookId, "Unavailable", name, authorName, yearPublished);
        }
    }

    private int getFirstISBN() {
        return isbn.get(0);
    }

    private boolean isAnyBookAvailable() {
        return !isbn.isEmpty();
    }

    public boolean isSameBookId(int id) {
        return this.bookId == id;
    }
}
