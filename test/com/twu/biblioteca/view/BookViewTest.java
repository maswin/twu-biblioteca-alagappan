package com.twu.biblioteca.view;

import com.twu.biblioteca.DTO.BookDTO;
import com.twu.biblioteca.InputOutput.InputReader;
import com.twu.biblioteca.InputOutput.OutputWriter;
import com.twu.biblioteca.model.Copy;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BookViewTest {

    private OutputWriter outputWriter;
    private InputReader inputReader;

    @Before
    public void setUp() throws Exception {
        outputWriter = mock(OutputWriter.class);
        inputReader = mock(InputReader.class);
    }

    @Test
    public void shouldPrintListOfBooks() {
        OutputWriter outputWriter = mock(OutputWriter.class);
        BookView bookView = new BookView(outputWriter, inputReader);
        List<BookDTO> books = new ArrayList<>();
        BookDTO book1 = mock(BookDTO.class);
        books.add(book1);
        BookDTO book2 = mock(BookDTO.class);
        books.add(book2);
        bookView.printBooks(books);

        verify(outputWriter).println("List Of Books Available");
        verify(outputWriter).println(String.format("%-12s %-25s %-20s %s", "ISBN", "Book Name", "Author Name", "Year"));
        verify(outputWriter).println(String.format("%-12d %-25s %-20s %d", book1.getIsbn(),
                book1.getName(), book1.getAuthorName(), book1.getYearPublished()));
        verify(outputWriter).println(String.format("%-12d %-25s %-20s %d", book2.getIsbn(),
                book2.getName(), book2.getAuthorName(), book2.getYearPublished()));
    }

    @Test
    public void shouldGetBookIdFromUser() {
        BookView bookView = new BookView(outputWriter, inputReader);

        when(inputReader.readInt()).thenReturn(2);
        assertEquals(2, bookView.getBookId());
        verify(outputWriter).println("Enter Book ISBN :");

    }

    @Test
    public void shouldPrintSuccessBookCheckoutMessage() throws Exception {
        BookView bookView = new BookView(outputWriter, inputReader);
        bookView.printSuccessfulBookCheckoutMessage();
        verify(outputWriter).println("Thank you! Enjoy the book");
    }

    @Test
    public void shouldPrintUnSuccessBookCheckoutMessage() throws Exception {
        BookView bookView = new BookView(outputWriter, inputReader);
        bookView.printUnSuccessfulBookCheckoutMessage();
        verify(outputWriter).println("That book is not available.");
    }

    @Test
    public void shouldPrintSuccessBookCheckinMessage() throws Exception {
        BookView bookView = new BookView(outputWriter, inputReader);
        bookView.printSuccessfulBookCheckInMessage();
        verify(outputWriter).println("Thank you for returning the book.");
    }

    @Test
    public void shouldPrintUnSuccessBookCheckinMessage() throws Exception {
        BookView bookView = new BookView(outputWriter, inputReader);
        bookView.printUnSuccessfulBookCheckInMessage();
        verify(outputWriter).println("That is not a valid book to return.");
    }

    @Test
    public void shouldPrintBookCopy() throws Exception {
        BookView bookView = new BookView(outputWriter, inputReader);
        Copy copy = mock(Copy.class);
        bookView.printBookCopy(copy);
        verify(outputWriter).println("Status of the book : ");
        verify(outputWriter).println(copy);

    }

    @Test
    public void shouldPrintBookNotFoundMessage() throws Exception {
        BookView bookView = new BookView(outputWriter, inputReader);
        bookView.printBookCopyNotFound();
        verify(outputWriter).println("Book Copy Not Found !!");
    }
}
