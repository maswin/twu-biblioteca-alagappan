package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.view.BibliotecaView;

public class CheckOutBookCommand implements MenuCommand {

    private final BibliotecaView bibliotecaView;
    private final Library library;

    public CheckOutBookCommand(BibliotecaView bibliotecaView, Library library) {
        this.bibliotecaView = bibliotecaView;
        this.library = library;
    }

    private void checkOutBook(int bookId) {
        if(library.isBookAvailable(bookId)) {
            library.checkOut(bookId);
            bibliotecaView.printSuccessfulBookCheckoutMessage();
        } else {
            bibliotecaView.printUnSuccessfulBookCheckoutMessage();
        }
    }

    @Override
    public void performCommand() {
        int bookId = bibliotecaView.getBookId();
        checkOutBook(bookId);
    }
}
