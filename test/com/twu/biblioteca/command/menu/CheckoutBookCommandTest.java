package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Exception.LibraryItemProcessingException;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Role;
import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.view.BookView;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashSet;

import static org.mockito.Mockito.*;

public class CheckOutBookCommandTest {

    @Test
    public void shouldCheckoutBookAndPrintSuccessMessageWhenBookIsAvailable() throws Exception {
        Library library = Mockito.mock(Library.class);
        BookView bookView = Mockito.mock(BookView.class);

        User user = mock(User.class);
        when(user.getRole()).thenReturn(Role.MEMBER);

        int isbn = 12;
        when(bookView.getBookId()).thenReturn(isbn);
        MenuCommand menuCommand = new CheckOutBookCommand(bookView, library, new HashSet<Role>() {{
            add(Role.MEMBER);
        }});


        menuCommand.execute(user);

        verify(library).checkOutBookCopy(isbn, user);
        verify(bookView).printSuccessfulBookCheckoutMessage();
    }

    @Test
    public void shouldTryCheckingOutBookAndPrintUnSuccessMessageWhenBookIsUnAvailable() throws Exception {
        Library library = Mockito.mock(Library.class);
        BookView bookView = Mockito.mock(BookView.class);

        User user = mock(User.class);
        when(user.getRole()).thenReturn(Role.MEMBER);

        int isbn = 12;
        when(bookView.getBookId()).thenReturn(isbn);
        doThrow(new LibraryItemProcessingException("Book Copy Unavailable")).when(library).checkOutBookCopy(isbn, user);
        MenuCommand menuCommand = new CheckOutBookCommand(bookView, library, new HashSet<Role>() {{
            add(Role.MEMBER);
        }});

        menuCommand.execute(user);

        verify(bookView).printUnSuccessfulBookCheckoutMessage();
    }
}
