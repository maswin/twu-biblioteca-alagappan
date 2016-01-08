package com.twu.biblioteca.model;

public class Movie {
    private final String name;
    private final int yearOfRelease;
    private final String directorName;
    private final Integer rating;

    public Movie(String name, int yearOfRelease, String directorName, Integer rating) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.directorName = directorName;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public Integer getRating() {
        return rating;
    }

    public String getDirectorName() {
        return directorName;
    }
}
