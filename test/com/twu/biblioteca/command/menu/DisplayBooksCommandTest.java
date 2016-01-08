package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.DTO.BookDTO;
import com.twu.biblioteca.Exception.BookCopyProcessingException;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.BibliotecaView;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DisplayBooksCommandTest {

    @Test
    public void shouldDisplayBooks() throws BookCopyProcessingException {
        BibliotecaView bibliotecaView = Mockito.mock(BibliotecaView.class);
        Library library = Mockito.mock(Library.class);
        List<BookDTO> books = new ArrayList<>();
        when(library.getListOfAvailableBookDTO()).thenReturn(books);
        MenuCommand menuCommand = new DisplayBooksCommand(bibliotecaView, library);
        try {
            menuCommand.performCommand();
        } catch (Exception e) {
            e.printStackTrace();
        }

        verify(bibliotecaView).printBooks(books);
    }
}
