package com.twu.biblioteca.view;

import com.twu.biblioteca.DTO.MovieDTO;
import com.twu.biblioteca.InputOutput.InputReader;
import com.twu.biblioteca.InputOutput.OutputWriter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

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
}
