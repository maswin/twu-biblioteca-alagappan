package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Movie;
import com.twu.biblioteca.view.MovieView;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DisplayMoviesCommandTest {

    @Test
    public void shouldDisplayMovies() throws Exception {
        MovieView movieView = Mockito.mock(MovieView.class);
        Library library = Mockito.mock(Library.class);
        List<Movie> movies = new ArrayList<>();
        when(library.getListOfAvailableMovies()).thenReturn(movies);

        MenuCommand displayMoviesCommand = new DisplayMoviesCommand(movieView, library);

        displayMoviesCommand.performCommand();
        verify(movieView).printMovies(movies);
    }
}
