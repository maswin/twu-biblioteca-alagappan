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
        return String.format("%-25s %-20s %d", name, authorName, yearPublished);
    }

    public boolean isAnyBookAvailable() {
        return !isbns.isEmpty();
    }

    public int getFirstAvailableIsbn(Set<Integer> unavailableIsbns) {
        for(Integer isbn : isbns) {
            if(!unavailableIsbns.contains(isbn)) {
                return isbn;
            }
        }
        return 0;
    }

    public boolean isIsbnOfThisBookType(int isbn) {
        return isbns.contains(isbn);
    }

    public int numberOfBooksAvailable() {
        return isbns.size();
    }
}
