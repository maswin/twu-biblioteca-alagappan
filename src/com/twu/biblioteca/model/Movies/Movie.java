package com.twu.biblioteca.model.Movies;

import com.twu.biblioteca.DTO.MovieDTO;
import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import com.twu.biblioteca.model.Copy;
import com.twu.biblioteca.model.LibraryItem;

import java.util.Set;

public class Movie extends LibraryItem{
    private final String directorName;
    private final Integer rating;

    public Movie(int movieId, String name, String directorName, int year, Integer rating, Set<Copy> copies, String genre) {
        super(movieId, name, year, copies);
        this.directorName = directorName;
        this.rating = rating;
    }

    public MovieDTO createMovieDTO() throws LibraryItemProcessingException {
        return new MovieDTO(getAnyUnBorrowedCopy().getIsbn(), name, directorName, year, rating);
    }
}
