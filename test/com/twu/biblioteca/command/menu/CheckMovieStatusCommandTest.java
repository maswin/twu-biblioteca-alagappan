package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import com.twu.biblioteca.model.Copy;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Role;
import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.view.MovieView;
import org.junit.Test;

import java.util.HashSet;

import static org.mockito.Mockito.*;

public class CheckMovieStatusCommandTest {

    @Test
    public void shouldPrintTheStatusOfTheBook() throws Exception {
        int isbn = 1234;
        Library library = mock(Library.class);
        MovieView movieView = mock(MovieView.class);
        Copy copy = mock(Copy.class);
        when(movieView.getMovieId()).thenReturn(isbn);
        when(library.findMovieCopyByIsbn(isbn)).thenReturn(copy);
        MenuCommand menuCommand = new CheckMovieStatusCommand(library, movieView, new HashSet<Role>() {{
            add(Role.MEMBER);
        }});

        User user = mock(User.class);
        when(user.getRole()).thenReturn(Role.MEMBER);
        menuCommand.execute(user);

        verify(movieView).printMovieCopy(copy);
    }

    @Test
    public void shouldThrowExceptionWhenBookCopyNotFound() throws Exception {
        int isbn = 1234;
        Library library = mock(Library.class);
        MovieView movieView = mock(MovieView.class);
        when(movieView.getMovieId()).thenReturn(isbn);
        doThrow(new LibraryItemProcessingException("Book Copy Not Found")).when(library).findMovieCopyByIsbn(isbn);
        MenuCommand menuCommand = new CheckMovieStatusCommand(library, movieView, new HashSet<Role>() {{
            add(Role.MEMBER);
        }});

        User user = mock(User.class);
        when(user.getRole()).thenReturn(Role.MEMBER);
        menuCommand.execute(user);

        verify(movieView).printMovieCopyNotFound();
    }
}
