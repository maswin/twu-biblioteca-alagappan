package com.twu.biblioteca.view;

import com.twu.biblioteca.DTO.MovieDTO;
import com.twu.biblioteca.InputOutput.InputReader;
import com.twu.biblioteca.InputOutput.OutputWriter;
import com.twu.biblioteca.model.Copy;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieViewTest {
    private OutputWriter outputWriter;
    private InputReader inputReader;

    @Before
    public void setUp() throws Exception {
        outputWriter = Mockito.mock(OutputWriter.class);
        inputReader = Mockito.mock(InputReader.class);
    }

    @Test
    public void shouldPrintListOfMovies() {
        OutputWriter outputWriter = Mockito.mock(OutputWriter.class);
        MovieView movieView = new MovieView(outputWriter, inputReader);
        List<MovieDTO> movies = new ArrayList<>();
        MovieDTO movie1 = Mockito.mock(MovieDTO.class);
        when(movie1.getRating()).thenReturn(null);
        movies.add(movie1);
        MovieDTO movie2 = Mockito.mock(MovieDTO.class);
        movies.add(movie2);
        when(movie2.getRating()).thenReturn(5);
        movieView.printMovies(movies);

        verify(outputWriter).println("List Of Movies Available");
        verify(outputWriter).println(String.format("%-12s %-25s %-20s %s %12s",
                "ISBN", "Movie Name", "Director Name", "Year", "Rating"));
        verify(outputWriter).println(String.format("%-12d %-25s %-20s %d", movie1.getIsbn(),
                movie1.getName(), movie1.getDirectorName(), movie1.getYear(), "Unrated"));
        verify(outputWriter).println(String.format("%-12d %-25s %-20s %d", movie2.getIsbn(),
                movie2.getName(), movie2.getDirectorName(), movie2.getYear(), "5"));
    }

    @Test
    public void shouldGetMovieIdFromUser() {
        MovieView movieView = new MovieView(outputWriter, inputReader);

        when(inputReader.readInt()).thenReturn(2);
        assertEquals(2, movieView.getMovieId());
        verify(outputWriter).println("Enter Movie ISBN :");

    }

    @Test
    public void shouldPrintSuccessMoveCheckoutMessage() throws Exception {
        MovieView movieView = new MovieView(outputWriter, inputReader);
        movieView.printSuccessfulMovieCheckoutMessage();
        verify(outputWriter).println("Thank you! Enjoy the movie");
    }

    @Test
    public void shouldPrintUnSuccessMovieCheckoutMessage() throws Exception {
        MovieView movieView = new MovieView(outputWriter, inputReader);
        movieView.printUnSuccessfulMovieCheckoutMessage();
        verify(outputWriter).println("That movie is not available.");
    }

    @Test
    public void shouldPrintBookCopy() throws Exception {
        MovieView movieView = new MovieView(outputWriter, inputReader);
        Copy copy = mock(Copy.class);
        movieView.printMovieCopy(copy);
        verify(outputWriter).println("Status of the Movie : ");
        verify(outputWriter).println(copy);

    }

    @Test
    public void shouldPrintBookNotFoundMessage() throws Exception {
        MovieView movieView = new MovieView(outputWriter, inputReader);
        movieView.printMovieCopyNotFound();
        verify(outputWriter).println("Movie Copy Not Found !!");
    }
}
