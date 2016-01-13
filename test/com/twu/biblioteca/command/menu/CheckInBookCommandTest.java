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

public class CheckInBookCommandTest {

    @Test
    public void checkInBookIfTheBookIsBorrowedAndPrintSuccessMessage() throws Exception {
        int isbn = 22;
        Library library = Mockito.mock(Library.class);
        BookView bookView = Mockito.mock(BookView.class);
        User user = mock(User.class);
        when(bookView.getBookId()).thenReturn(isbn);
        MenuCommand menuCommand = new CheckInBookCommand(bookView, library, new HashSet<Role>() {{
            add(Role.MEMBER);
        }});

        when(user.getRole()).thenReturn(Role.MEMBER);
        menuCommand.execute(user);

        verify(library).checkInBookCopy(isbn, user);
        verify(bookView).printSuccessfulBookCheckInMessage();
    }

    @Test
    public void shouldNotCheckInBookIfTheBookIsNotBorrowedAndPrintUnSuccessMessage() throws Exception {
        int isbn = 22;
        Library library = Mockito.mock(Library.class);
        BookView bookView = Mockito.mock(BookView.class);
        User user = mock(User.class);
        when(bookView.getBookId()).thenReturn(isbn);
        doThrow(new LibraryItemProcessingException("Book Copy Unavailable")).when(library).checkInBookCopy(isbn, user);
        MenuCommand menuCommand = new CheckInBookCommand(bookView, library, new HashSet<Role>() {{
            add(Role.MEMBER);
        }});

        when(user.getRole()).thenReturn(Role.MEMBER);
        menuCommand.execute(user);

        verify(bookView).printUnSuccessfulBookCheckInMessage();
    }

}
