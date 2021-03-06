package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.DTO.MovieDTO;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Role;
import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.view.MovieView;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DisplayMoviesCommandTest {

    @Test
    public void shouldDisplayMovies() throws Exception {
        MovieView movieView = Mockito.mock(MovieView.class);
        Library library = Mockito.mock(Library.class);
        List<MovieDTO> movies = new ArrayList<>();
        when(library.getListOfAvailableMovieDTO()).thenReturn(movies);
        MenuCommand menuCommand = new DisplayMoviesCommand(movieView, library, new HashSet<Role>() {{
            add(Role.MEMBER);
        }});

        User user = mock(User.class);
        when(user.getRole()).thenReturn(Role.MEMBER);
        menuCommand.execute(user);

        verify(movieView).printMovies(movies);
    }
}
