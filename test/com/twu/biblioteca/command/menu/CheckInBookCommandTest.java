package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.view.BibliotecaView;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckInBookCommandTest {

    @Test
    public void checkInBookIfTheBookIsInBorrowedBooksList() {
        int bookId = 22;
        Library library = Mockito.mock(Library.class);
        BibliotecaView bibliotecaView = Mockito.mock(BibliotecaView.class);
        when(bibliotecaView.getBookId()).thenReturn(bookId);
        when(library.isBorrowedBook(bookId)).thenReturn(true);
        MenuCommand menuCommand = new CheckInBookCommand(bibliotecaView, library);

        menuCommand.performCommand();

        verify(library).checkIn(bookId);
    }

}
