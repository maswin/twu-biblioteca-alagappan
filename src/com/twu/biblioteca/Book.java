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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (yearPublished != book.yearPublished) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        return authorName != null ? authorName.equals(book.authorName) : book.authorName == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (authorName != null ? authorName.hashCode() : 0);
        result = 31 * result + yearPublished;
        return result;
    }
}
