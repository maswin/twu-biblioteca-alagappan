package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Exception.BookCopyProcessingException;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.BibliotecaView;

public class CheckInBookCommand implements MenuCommand {
    private final BibliotecaView bibliotecaView;
    private Library library;

    public CheckInBookCommand(BibliotecaView bibliotecaView, Library library) {
        this.bibliotecaView = bibliotecaView;
        this.library = library;
    }

    private void checkInBook(int bookId) throws BookCopyProcessingException {
        if(library.isBorrowedBookCopy(bookId)) {
            library.checkInBookCopy(bookId);
            bibliotecaView.printSuccessfulBookCheckInMessage();
        } else {
            bibliotecaView.printUnSuccessfulBookCheckInMessage();
        }
    }

    @Override
    public void performCommand() throws Exception {
        int bookId = bibliotecaView.getBookId();
        checkInBook(bookId);
    }
}
