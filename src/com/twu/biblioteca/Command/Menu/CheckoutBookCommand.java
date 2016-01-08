package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Exception.BookCopyProcessingException;
import com.twu.biblioteca.model.Library;
import com.twu.biblioteca.view.BibliotecaView;

public class CheckOutBookCommand implements MenuCommand {

    private final BibliotecaView bibliotecaView;
    private final Library library;

    public CheckOutBookCommand(BibliotecaView bibliotecaView, Library library) {
        this.bibliotecaView = bibliotecaView;
        this.library = library;
    }

    private void checkOutBook(int bookId) {
        try {
            library.checkOutBookCopy(bookId);
            bibliotecaView.printSuccessfulBookCheckoutMessage();
        } catch (BookCopyProcessingException e) {
            bibliotecaView.printUnSuccessfulBookCheckoutMessage();
        }
    }

    @Override
    public void performCommand() throws Exception {
        int bookId = bibliotecaView.getBookId();
        checkOutBook(bookId);
    }
}
