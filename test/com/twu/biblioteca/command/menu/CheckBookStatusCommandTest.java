package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import com.twu.biblioteca.model.Copy;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Role;
import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.view.BookView;
import org.junit.Test;

import java.util.HashSet;

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
        MenuCommand menuCommand = new CheckBookStatusCommand(library, bookView, new HashSet<Role>() {{
            add(Role.MEMBER);
        }});

        User user = mock(User.class);
        when(user.getRole()).thenReturn(Role.MEMBER);
        menuCommand.execute(user);

        verify(bookView).printBookCopy(copy);
    }

    @Test
    public void shouldThrowExceptionWhenBookCopyNotFound() throws Exception {
        int isbn = 1234;
        Library library = mock(Library.class);
        BookView bookView = mock(BookView.class);
        when(bookView.getBookId()).thenReturn(isbn);
        doThrow(new LibraryItemProcessingException("Book Copy Not Found")).when(library).findBookCopyByIsbn(isbn);
        MenuCommand menuCommand = new CheckBookStatusCommand(library, bookView, new HashSet<Role>() {{
            add(Role.MEMBER);
        }});

        User user = mock(User.class);
        when(user.getRole()).thenReturn(Role.MEMBER);
        menuCommand.execute(user);

        verify(bookView).printBookCopyNotFound();
    }
}
