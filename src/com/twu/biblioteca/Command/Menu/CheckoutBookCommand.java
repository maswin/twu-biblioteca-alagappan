package com.twu.biblioteca.command.menu;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.view.BibliotecaView;

public class CheckoutBookCommand implements MenuCommand {

    private final BibliotecaView bibliotecaView;
    private final Library library;

    public CheckoutBookCommand(BibliotecaView bibliotecaView, Library library) {
        this.bibliotecaView = bibliotecaView;
        this.library = library;
    }

    private void checkOutBook(int bookId) {

        Book foundBook = library.findBookById(bookId);

        if(foundBook != null) {
            library.checkOut(bookId);
            bibliotecaView.printSuccessfulCheckoutMessage();
        } else {
            bibliotecaView.printUnSuccessfulCheckoutMessage();
        }

    }
    @Override
    public void performCommand() {
        int bookId = bibliotecaView.getBookId();
        checkOutBook(bookId);
    }
}
