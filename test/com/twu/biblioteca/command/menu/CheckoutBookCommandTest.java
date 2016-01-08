package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Exception.BookCopyProcessingException;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.BibliotecaView;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckOutBookCommandTest {

    @Test
    public void shouldCheckoutBookAndPrintSuccessMessageWhenBookIsAvailable() throws Exception {
        Library library = Mockito.mock(Library.class);
        BibliotecaView bibliotecaView = Mockito.mock(BibliotecaView.class);
        int bookId = 12;
        when(bibliotecaView.getBookId()).thenReturn(bookId);
        MenuCommand menuCommand = new CheckOutBookCommand(bibliotecaView, library);

        menuCommand.performCommand();

        verify(library).checkOutBookCopy(bookId);
        verify(bibliotecaView).printSuccessfulBookCheckoutMessage();
    }

    @Test
    public void shouldTryCheckingOutBookAndPrintUnSuccessMessageWhenBookIsUnAvailable() throws Exception {
        Library library = Mockito.mock(Library.class);
        BibliotecaView bibliotecaView = Mockito.mock(BibliotecaView.class);
        int bookId = 12;
        when(bibliotecaView.getBookId()).thenReturn(bookId);
        doThrow(new BookCopyProcessingException("Book Copy Unavailable")).when(library).checkOutBookCopy(bookId);
        MenuCommand menuCommand = new CheckOutBookCommand(bibliotecaView, library);

        menuCommand.performCommand();

        verify(bibliotecaView).printUnSuccessfulBookCheckoutMessage();
    }

}
