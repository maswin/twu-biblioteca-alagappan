package com.twu.biblioteca.view;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.InputOutput.InputReader;
import com.twu.biblioteca.InputOutput.OutputWriter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BibliotecaViewTest {

    private OutputWriter outputWriter;
    private InputReader inputReader;

    @Before
    public void setUp() throws Exception {
        outputWriter = Mockito.mock(OutputWriter.class);
        inputReader = Mockito.mock(InputReader.class);
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        BibliotecaView bibliotecaView = new BibliotecaView("Welcome to com.twu.biblioteca.Biblioteca !!", outputWriter, inputReader);
        bibliotecaView.printWelcomeMessage();
        verify(outputWriter).println("Welcome to com.twu.biblioteca.Biblioteca !!");
    }

    @Test
    public void shouldPrintListOfBooks() {
        OutputWriter outputWriter = Mockito.mock(OutputWriter.class);
        BibliotecaView bibliotecaView = new BibliotecaView("Welcome to com.twu.biblioteca.Biblioteca !!", outputWriter, inputReader);
        List<Book> books = new ArrayList<>();
        Book book1 = Mockito.mock(Book.class);
        books.add(book1);
        Book book2 = Mockito.mock(Book.class);
        books.add(book2);
        bibliotecaView.printBooks(books);

        verify(outputWriter).println("List Of Books Available");
        verify(outputWriter).println(book1);
        verify(outputWriter).println(book2);
    }

    @Test
    public void shouldGetBookNameFromUser() {
        BibliotecaView bibliotecaView = new BibliotecaView("Welcome to com.twu.biblioteca.Biblioteca !!", outputWriter, inputReader);

        when(inputReader.readLine()).thenReturn("book name");
        assertEquals("book name", bibliotecaView.getBookName());

    }
}
