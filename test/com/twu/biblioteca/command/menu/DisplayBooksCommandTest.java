package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.DTO.BookDTO;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.BookView;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DisplayBooksCommandTest {

    @Test
    public void shouldDisplayBooks() throws Exception {
        BookView bookView = Mockito.mock(BookView.class);
        Library library = Mockito.mock(Library.class);
        List<BookDTO> books = new ArrayList<>();
        when(library.getListOfAvailableBookDTO()).thenReturn(books);
        MenuCommand menuCommand = new DisplayBooksCommand(bookView, library);

        menuCommand.performCommand(null);

        verify(bookView).printBooks(books);
    }
}
