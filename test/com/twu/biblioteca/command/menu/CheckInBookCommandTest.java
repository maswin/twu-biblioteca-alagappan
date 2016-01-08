package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Exception.BookCopyProcessingException;
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

        menuCommand.performCommand();

        verify(library).checkInBookCopy(isbn);
        verify(bookView).printSuccessfulBookCheckInMessage();
    }

    @Test
    public void shouldNotCheckInBookIfTheBookIsNotBorrowedAndPrintUnSuccessMessage() throws Exception {
        int isbn = 22;
        Library library = Mockito.mock(Library.class);
        BookView bookView = Mockito.mock(BookView.class);
        when(bookView.getBookId()).thenReturn(isbn);
        doThrow(new BookCopyProcessingException("Book Copy Unavailable")).when(library).checkInBookCopy(isbn);
        MenuCommand menuCommand = new CheckInBookCommand(bookView, library);

        menuCommand.performCommand();

        verify(bookView).printUnSuccessfulBookCheckInMessage();
    }

}
