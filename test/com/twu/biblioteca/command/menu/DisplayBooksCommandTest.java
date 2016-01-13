package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.DTO.BookDTO;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.model.Role;
import com.twu.biblioteca.model.Users.User;
import com.twu.biblioteca.view.BookView;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DisplayBooksCommandTest {

    @Test
    public void shouldDisplayBooks() throws Exception {
        BookView bookView = Mockito.mock(BookView.class);
        Library library = Mockito.mock(Library.class);
        List<BookDTO> books = new ArrayList<>();
        when(library.getListOfAvailableBookDTO()).thenReturn(books);
        MenuCommand menuCommand = new DisplayBooksCommand(bookView, library, new HashSet<Role>() {{
            add(Role.MEMBER);
        }});

        User user = mock(User.class);
        when(user.getRole()).thenReturn(Role.MEMBER);
        menuCommand.execute(user);

        verify(bookView).printBooks(books);
    }
}
