package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.view.BibliotecaView;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

public class DisplayBooksCommandTest {

    @Test
    public void shouldDisplayBooks() {
        BibliotecaView bibliotecaView = Mockito.mock(BibliotecaView.class);
        List<Book> books = new ArrayList<>();

        MenuCommand menuCommand = new DisplayBooksCommand(bibliotecaView, books);
        menuCommand.performCommand();

        verify(bibliotecaView).printBooks(books);
    }
}
