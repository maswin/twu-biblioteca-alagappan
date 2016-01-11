package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.BookView;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckOutBookCommandTest {

    @Test
    public void shouldCheckoutBookAndPrintSuccessMessageWhenBookIsAvailable() throws Exception {
        Library library = Mockito.mock(Library.class);
        BookView bookView = Mockito.mock(BookView.class);
        int isbn = 12;
        when(bookView.getBookId()).thenReturn(isbn);
        MenuCommand menuCommand = new CheckOutBookCommand(bookView, library);

        menuCommand.performCommand();

        verify(library).checkOutBookCopy(isbn);
        verify(bookView).printSuccessfulBookCheckoutMessage();
    }

    @Test
    public void shouldTryCheckingOutBookAndPrintUnSuccessMessageWhenBookIsUnAvailable() throws Exception {
        Library library = Mockito.mock(Library.class);
        BookView bookView = Mockito.mock(BookView.class);
        int isbn = 12;
        when(bookView.getBookId()).thenReturn(isbn);
        doThrow(new LibraryItemProcessingException("Book Copy Unavailable")).when(library).checkOutBookCopy(isbn);
        MenuCommand menuCommand = new CheckOutBookCommand(bookView, library);

        menuCommand.performCommand();

        verify(bookView).printUnSuccessfulBookCheckoutMessage();
    }

}
