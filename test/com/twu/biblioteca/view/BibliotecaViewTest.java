package com.twu.biblioteca.view;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.InputOutput.OutputWriter;
import com.twu.biblioteca.view.BibliotecaView;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

public class BibliotecaViewTest {

    @Test
    public void shouldPrintWelcomeMessage() {
        OutputWriter outputWriter = Mockito.mock(OutputWriter.class);
        BibliotecaView bibliotecaView = new BibliotecaView("Welcome to com.twu.biblioteca.Biblioteca !!", outputWriter);
        bibliotecaView.printWelcomeMessage();
        verify(outputWriter).println("Welcome to com.twu.biblioteca.Biblioteca !!");
    }

    @Test
    public void shouldPrintListOfBooks() throws Exception {
        OutputWriter outputWriter = Mockito.mock(OutputWriter.class);
        BibliotecaView bibliotecaView = new BibliotecaView("Welcome to com.twu.biblioteca.Biblioteca !!", outputWriter);
        List<Book> books = new ArrayList<>();
        Book book1 = Mockito.mock(Book.class);
        books.add(book1);
        Book book2 = Mockito.mock(Book.class);
        books.add(book2);
        bibliotecaView.printBooks(books);
        verify(outputWriter).println(book1);
        verify(outputWriter).println(book2);
    }
}
