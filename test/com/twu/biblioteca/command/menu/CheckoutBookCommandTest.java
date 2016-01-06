package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.view.BibliotecaView;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckOutBookCommandTest {

    @Test
    public void shouldCheckoutBookAndPrintSuccessMessageWhenBookIsAvailable() {
        Library library = Mockito.mock(Library.class);
        BibliotecaView bibliotecaView = Mockito.mock(BibliotecaView.class);
        int bookId = 12;
        when(library.isBookAvailable(bookId)).thenReturn(true);
        when(bibliotecaView.getBookId()).thenReturn(bookId);
        MenuCommand menuCommand = new CheckOutBookCommand(bibliotecaView, library);

        menuCommand.performCommand();

        verify(library).checkOut(bookId);
        verify(bibliotecaView).printSuccessfulBookCheckoutMessage();
    }

    @Test
    public void shouldTryCheckingOutBookAndPrintUnSuccessMessageWhenBookIsUnAvailable() {
        Library library = Mockito.mock(Library.class);
        BibliotecaView bibliotecaView = Mockito.mock(BibliotecaView.class);
        int bookId = 12;
        when(bibliotecaView.getBookId()).thenReturn(bookId);
        MenuCommand menuCommand = new CheckOutBookCommand(bibliotecaView, library);

        menuCommand.performCommand();

        verify(bibliotecaView).printUnSuccessfulBookCheckoutMessage();
    }


}
