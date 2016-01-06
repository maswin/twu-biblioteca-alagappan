package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.view.BibliotecaView;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckoutBookCommandTest {

    @Test
    public void shouldCheckoutBookAndPrintSuccessMessageWhenBookIsAvailable() {
        Library library = Mockito.mock(Library.class);
        BibliotecaView bibliotecaView = Mockito.mock(BibliotecaView.class);
        int bookId = 12;
        when(library.isBookAvailable(bookId)).thenReturn(true);
        when(bibliotecaView.getBookId()).thenReturn(bookId);
        Book book = Mockito.mock(Book.class);
        when(library.findBookById(bookId)).thenReturn(book);
        MenuCommand menuCommand = new CheckoutBookCommand(bibliotecaView, library);

        menuCommand.performCommand();

        verify(library).checkOut(bookId);
        verify(bibliotecaView).printSuccessfulCheckoutMessage();
    }

    @Test
    public void shouldTryCheckingOutBookAndPrintUnSuccessMessageWhenBookIsUnAvailable() {
        Library library = Mockito.mock(Library.class);
        BibliotecaView bibliotecaView = Mockito.mock(BibliotecaView.class);
        int bookId = 12;
        when(bibliotecaView.getBookId()).thenReturn(bookId);
        Book book = null;
        when(library.findBookById(bookId)).thenReturn(book);
        MenuCommand menuCommand = new CheckoutBookCommand(bibliotecaView, library);

        menuCommand.performCommand();

        verify(bibliotecaView).printUnSuccessfulCheckoutMessage();
    }


}
