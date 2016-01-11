package com.twu.biblioteca.model.Movies;

import com.twu.biblioteca.DTO.MovieDTO;
import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import com.twu.biblioteca.model.Copy;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class MovieTest {

    @Test
    public void shouldGenerateMovieDTO() throws LibraryItemProcessingException {
        Copy copy = Mockito.mock(Copy.class);
        when(copy.isBorrowed()).thenReturn(false);
        when(copy.getIsbn()).thenReturn(1234);
        Set<Copy> copies = new HashSet<>();
        copies.add(copy);

        Movie movie = new Movie(21, "movie1", "director1", 2010, 5, copies);

        MovieDTO movieDTO = movie.createMovieDTO();

        assertEquals("movie1", movieDTO.getName());
        assertEquals("director1", movieDTO.getDirectorName());
        assertEquals(2010, movieDTO.getYear());
        assertEquals(1234, movieDTO.getIsbn());
    }
}
