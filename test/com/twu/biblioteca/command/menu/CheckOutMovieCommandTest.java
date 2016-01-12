package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.MovieView;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckOutMovieCommandTest {

    @Test
    public void shouldCheckoutMovieAndPrintSuccessMessageWhenBookIsAvailable() throws Exception {
        Library library = Mockito.mock(Library.class);
        MovieView movieView = Mockito.mock(MovieView.class);
        int isbn = 12;
        when(movieView.getMovieId()).thenReturn(isbn);
        MenuCommand menuCommand = new CheckOutMovieCommand(movieView, library);

        menuCommand.performCommand(null);

        verify(library).checkOutMovieCopy(isbn, null);
        verify(movieView).printSuccessfulMovieCheckoutMessage();
    }

    @Test
    public void shouldTryCheckingOutMovieAndPrintUnSuccessMessageWhenMovieIsUnAvailable() throws Exception {
        Library library = Mockito.mock(Library.class);
        MovieView movieView = Mockito.mock(MovieView.class);
        int isbn = 12;
        when(movieView.getMovieId()).thenReturn(isbn);
        doThrow(new LibraryItemProcessingException("Movie Copy Unavailable")).when(library).checkOutMovieCopy(isbn, null);
        MenuCommand menuCommand = new CheckOutMovieCommand(movieView, library);

        menuCommand.performCommand(null);

        verify(movieView).printUnSuccessfulMovieCheckoutMessage();
    }
}
