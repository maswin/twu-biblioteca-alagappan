package com.twu.biblioteca.view;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.DTO.BookDTO;
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
        List<BookDTO> books = new ArrayList<>();
        BookDTO book1 = Mockito.mock(BookDTO.class);
        books.add(book1);
        BookDTO book2 = Mockito.mock(BookDTO.class);
        books.add(book2);
        bibliotecaView.printBooks(books);

        verify(outputWriter).println("List Of Books Available");
        verify(outputWriter).println(String.format("%-12s %-25s %-20s %s", "ISBN", "Book Name", "Author Name", "Year"));
        verify(outputWriter).println(String.format("%-12d %-25s %-20s %d", book1.getIsbn(),
                book1.getName(), book1.getAuthorName(), book1.getYearPublished()));
        verify(outputWriter).println(String.format("%-12d %-25s %-20s %d", book2.getIsbn(),
                book2.getName(), book2.getAuthorName(), book2.getYearPublished()));
    }

    @Test
    public void shouldGetBookIdFromUser() {
        BibliotecaView bibliotecaView = new BibliotecaView("Welcome to com.twu.biblioteca.Biblioteca !!", outputWriter, inputReader);

        when(inputReader.readInt()).thenReturn(2);
        assertEquals(2, bibliotecaView.getBookId());
        verify(outputWriter).println("Enter Book ISBN :");

    }

    @Test
    public void shouldPrintSuccessBookCheckoutMessage() throws Exception {
        BibliotecaView bibliotecaView = new BibliotecaView("Welcome to com.twu.biblioteca.Biblioteca !!", outputWriter, inputReader);
        bibliotecaView.printSuccessfulBookCheckoutMessage();
        verify(outputWriter).println("Thank you! Enjoy the book");
    }

    @Test
    public void shouldPrintUnSuccessBookCheckoutMessage() throws Exception {
        BibliotecaView bibliotecaView = new BibliotecaView("Welcome to com.twu.biblioteca.Biblioteca !!", outputWriter, inputReader);
        bibliotecaView.printUnSuccessfulBookCheckoutMessage();
        verify(outputWriter).println("That book is not available.");
    }

    @Test
    public void shouldPrintSuccessBookCheckinMessage() throws Exception {
        BibliotecaView bibliotecaView = new BibliotecaView("Welcome to com.twu.biblioteca.Biblioteca !!", outputWriter, inputReader);
        bibliotecaView.printSuccessfulBookCheckInMessage();
        verify(outputWriter).println("Thank you for returning the book.");
    }

    @Test
    public void shouldPrintUnSuccessBookCheckinMessage() throws Exception {
        BibliotecaView bibliotecaView = new BibliotecaView("Welcome to com.twu.biblioteca.Biblioteca !!", outputWriter, inputReader);
        bibliotecaView.printUnSuccessfulBookCheckInMessage();
        verify(outputWriter).println("That is not a valid book to return.");
    }
}
