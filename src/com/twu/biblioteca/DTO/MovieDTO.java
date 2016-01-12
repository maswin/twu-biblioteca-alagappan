package com.twu.biblioteca.DTO;

public class MovieDTO implements LibraryItemDTO {
    private final int isbn;
    private final String name;
    private final String directorName;
    private final int year;
    private final Integer rating;

    public MovieDTO(int isbn, String name, String directorName, int year, Integer rating) {
        this.isbn = isbn;
        this.name = name;
        this.directorName = directorName;
        this.year = year;
        this.rating = rating;
    }

    public int getIsbn() {
        return isbn;
    }

    public String getDirectorName() {
        return directorName;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public Integer getRating() {
        return rating;
    }
}
