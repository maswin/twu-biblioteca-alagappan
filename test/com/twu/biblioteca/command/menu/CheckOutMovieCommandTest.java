package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Role;
import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.view.MovieView;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashSet;

import static org.mockito.Mockito.*;

public class CheckOutMovieCommandTest {

    @Test
    public void shouldCheckoutMovieAndPrintSuccessMessageWhenBookIsAvailable() throws Exception {
        Library library = Mockito.mock(Library.class);
        MovieView movieView = Mockito.mock(MovieView.class);
        User user = mock(User.class);

        int isbn = 12;
        when(movieView.getMovieId()).thenReturn(isbn);
        MenuCommand menuCommand = new CheckOutMovieCommand(movieView, library, new HashSet<Role>() {{
            add(Role.MEMBER);
        }});

        when(user.getRole()).thenReturn(Role.MEMBER);
        menuCommand.execute(user);

        verify(library).checkOutMovieCopy(isbn, user);
        verify(movieView).printSuccessfulMovieCheckoutMessage();
    }

    @Test
    public void shouldTryCheckingOutMovieAndPrintUnSuccessMessageWhenMovieIsUnAvailable() throws Exception {
        Library library = Mockito.mock(Library.class);
        MovieView movieView = Mockito.mock(MovieView.class);
        User user = mock(User.class);

        int isbn = 12;
        when(movieView.getMovieId()).thenReturn(isbn);
        doThrow(new LibraryItemProcessingException("Movie Copy Unavailable")).when(library).checkOutMovieCopy(isbn, user);
        MenuCommand menuCommand = new CheckOutMovieCommand(movieView, library, new HashSet<Role>() {{
            add(Role.MEMBER);
        }});

        when(user.getRole()).thenReturn(Role.MEMBER);
        menuCommand.execute(user);

        verify(movieView).printUnSuccessfulMovieCheckoutMessage();
    }
}
