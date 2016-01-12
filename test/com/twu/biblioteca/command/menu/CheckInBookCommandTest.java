package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.BookView;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckInBookCommandTest {

    @Test
    public void checkInBookIfTheBookIsBorrowedAndPrintSuccessMessage() throws Exception {
        int isbn = 22;
        Library library = Mockito.mock(Library.class);
        BookView bookView = Mockito.mock(BookView.class);
        when(bookView.getBookId()).thenReturn(isbn);
        MenuCommand menuCommand = new CheckInBookCommand(bookView, library);

        menuCommand.performCommand(null);

        verify(library).checkInBookCopy(isbn, null);
        verify(bookView).printSuccessfulBookCheckInMessage();
    }

    @Test
    public void shouldNotCheckInBookIfTheBookIsNotBorrowedAndPrintUnSuccessMessage() throws Exception {
        int isbn = 22;
        Library library = Mockito.mock(Library.class);
        BookView bookView = Mockito.mock(BookView.class);
        when(bookView.getBookId()).thenReturn(isbn);
        doThrow(new LibraryItemProcessingException("Book Copy Unavailable")).when(library).checkInBookCopy(isbn, null);
        MenuCommand menuCommand = new CheckInBookCommand(bookView, library);

        menuCommand.performCommand(null);

        verify(bookView).printUnSuccessfulBookCheckInMessage();
    }

}
