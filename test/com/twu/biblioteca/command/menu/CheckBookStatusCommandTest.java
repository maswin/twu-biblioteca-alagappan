package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import com.twu.biblioteca.model.Copy;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.view.BookView;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CheckBookStatusCommandTest {

    @Test
    public void shouldPrintTheStatusOfTheBook() throws Exception {
        int isbn = 1234;
        Library library = mock(Library.class);
        BookView bookView = mock(BookView.class);
        Copy copy = mock(Copy.class);
        when(bookView.getBookId()).thenReturn(isbn);
        when(library.findBookCopyByIsbn(isbn)).thenReturn(copy);
        MenuCommand menuCommand = new CheckBookStatusCommand(library, bookView);

        menuCommand.performCommand(mock(User.class));

        verify(bookView).printBookCopy(copy);
    }

    @Test
    public void shouldThrowExceptionWhenBookCopyNotFound() throws Exception {
        int isbn = 1234;
        Library library = mock(Library.class);
        BookView bookView = mock(BookView.class);
        Copy copy = mock(Copy.class);
        when(bookView.getBookId()).thenReturn(isbn);
        doThrow(new LibraryItemProcessingException("Book Copy Not Found")).when(library).findBookCopyByIsbn(isbn);
        MenuCommand menuCommand = new CheckBookStatusCommand(library, bookView);

        menuCommand.performCommand(mock(User.class));

        verify(bookView).printBookCopyNotFound();
    }
}
