package com.twu.biblioteca;

import java.util.Set;

public class Book {
    private final int bookId;
    private final String name;
    private final String authorName;
    private final int yearPublished;
    private Set<Integer> isbns;

    public Book(int bookId, String name, String authorName, int yearPublished, Set<Integer> isbns) {
        this.bookId = bookId;
        this.name = name;
        this.authorName = authorName;
        this.yearPublished = yearPublished;
        this.isbns = isbns;
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
        return isbns.iterator().next();
    }

    public boolean isAnyBookAvailable() {
        return !isbns.isEmpty();
    }

    public boolean isIsbnOfThisBookType(int isbn) {
        return isbns.contains(isbn);
    }

    public int numberOfBooksAvailable() {
        return isbns.size();
    }
}
