package com.twu.biblioteca.DTO;

public class BookDTO {
    private final int isbn;
    private final String name;
    private final String authorName;
    private final int yearPublished;

    public BookDTO(int isbn, String name, String authorName, int yearPublished) {
        this.isbn = isbn;
        this.name = name;
        this.authorName = authorName;
        this.yearPublished = yearPublished;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getYearPublished() {
        return yearPublished;
    }

}
